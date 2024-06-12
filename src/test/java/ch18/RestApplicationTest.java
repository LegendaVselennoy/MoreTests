package ch18;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.NestedServletException;

import test.ch18.*;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

import static org.mockito.Mockito.when;

// @SpringBootTest выполняет поиск определений компонентов в текущем пакете тестового класса и его подпакетах
@SpringBootTest
// Аннотируем класс с помощью @AutoConfigureMockMvc, чтобы включить всю автоконфигурацию, связанную с объектами MockMvc, используемыми в тесте
@AutoConfigureMockMvc
// Импортируем FlightBuilder, который создает тестовый компонент и компонент карты стран
@Import(FlightBuilder.class)
public class RestApplicationTest {

    // Автоматически связывает объект MockMvc. MockMvc является основной точкой входа для тестирования серверных приложений Spring REST:
    // Выполним ряд операций REST с этим объектом MockMvc во время тестов.
    @Autowired
    private MockMvc mvc;
    // Объявляем поля flight и countriesMap и автоматически связывает их. Эти поля внедряются из класса FlightBuilder
    @Autowired
    private Map<String, Country>countriesMap;
    @Autowired
    private Flight flight;

    // Объявляем поля countryRepository и passengerRepository и аннотируем их @MockBean. @MockBean используется для добавления фиктивных объектов в
    // контекст приложения Spring; Макет заменит любой существующий компонент того же типа в контексте приложения.
    // Предоставим инструкции по поведению фиктивных объектов во время тестов
    @MockBean
    private PassengerRepository passengerRepository;
    @MockBean
    private CountryRepository countryRepository;

    @Test
    void testGetAllCountries() throws Exception {
    // В тесте testGetAllCountries он указывает фиктивному компоненту countryRepository возвращать массив значений из countriesMap при выполнении на нем метода findAll
        when(countryRepository.findAll()).thenReturn(new
                ArrayList<>(countriesMap.values()));
    // Имитируем выполнение метода GET для URL-адреса /countries и проверяем возвращаемое состояние,
        // ожидаемый тип содержимого и возвращаемый размер JSON. Он также проверяет, что метод findAll был выполнен ровно один раз на компоненте countryRepository
        mvc.perform(get("/countries"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(3)));
        verify(countryRepository, times(1)).findAll();
    }

    @Test
    void testGetAllPassengers() throws Exception {
        // В тесте testGetAllPassenger он указывает фиктивному компоненту passengerRepository возвращать пассажиров из полетного компонента при выполнении над ним метода findAll.
        // Имитирует выполнение метода GET для URL-адреса /passenger и проверяет возвращаемое состояние,
        // ожидаемый тип содержимого и возвращаемый размер JSON. Он также проверяет, что метод findAll был выполнен ровно один раз на компоненте passengerRepository
        when(passengerRepository.findAll()).thenReturn(new
                ArrayList<>(flight.getPassengers()));
        mvc.perform(get("/passengers"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(20)));
        verify(passengerRepository, times(1)).findAll();
    }

    /**
     * В testPassengerNotFound пытается получить пассажира с идентификатором 30 и проверяет,
     * что выдано исключение NestedServletException и что возвращенный статус — "Not Found".
     * Он также проверяет, что причиной исключения NestedServletException является PassengerNotFoundException
     */
    @Test
    void testPassengerNotFound() {
        Throwable throwable = assertThrows(NestedServletException.class,
                () -> mvc.perform(get("/passengers/30"))
                        .andExpect(status().isNotFound()));
        assertEquals(PassengerNotFoundException.class,
                throwable.getCause().getClass());
    }

    /**
     * В testPostPassenger создает объект passenger, настраивает его и указывает passengerRepository возвращать этот объект при выполнении сохранения на этом пассажире.
     * Он имитирует выполнение метода POST для URL-адреса /passenger и проверяет,
     * что содержимое состоит из строкового значения JSON объекта пассажира, типа заголовка, возвращаемого состояния и содержимого JSON.
     * Он использует объект типа com.fasterxml.jackson.databind.ObjectMapper,
     * который является основным классом библиотеки Jackson (стандартная JSON-библиотека для Java).
     * ObjectMapper предлагает функциональность для чтения и записи JSON в базовые POJO и из них.
     * Также проверяет, что метод сохранения был выполнен ровно один раз для ранее определенного пассажира
     */
    @Test
    void testPostPassenger() throws Exception {
        Passenger passenger = new Passenger("Peter Michelsen");
        passenger.setCountry(countriesMap.get("US"));
        passenger.setIsRegistered(false);
        when(passengerRepository.save(passenger))
                .thenReturn(passenger);
        mvc.perform(post("/passengers")
                        .content(new ObjectMapper().writeValueAsString(passenger))
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name", is("Peter Michelsen")))
                .andExpect(jsonPath("$.country.codeName", is("US")))
                .andExpect(jsonPath("$.country.name", is("USA")))
                .andExpect(jsonPath("$.registered", is(Boolean.FALSE)));
        verify(passengerRepository, times(1)).save(passenger);
    }

    /**
     * В testPatchPassenger он создает объект passenger, настраивает его и указывает passengerRepository возвращать этот объект при выполнении passenger findById с аргументом 1
     * (Когда метод save выполняется в passengerRepository, этот пассажир также возвращается).
     * Задает объект JSON с именем updates, выполняет PATCH для URL-адреса /passengers/1,
     * используя это обновление, и проверяет содержимое и возвращаемый статус.
     * Он проверяет, что методы findById и save были выполнены ровно один раз в passengerRepository
     */
    @Test
    void testPatchPassenger() throws Exception {
        Passenger passenger = new Passenger("Sophia Graham");
        passenger.setCountry(countriesMap.get("UK"));
        passenger.setIsRegistered(false);
        when(passengerRepository.findById(1L))
                .thenReturn(Optional.of(passenger));
        when(passengerRepository.save(passenger))
                .thenReturn(passenger);
        String updates =
                "{\"name\":\"Sophia Jones\", \"country\":\"AU\",\"isRegistered\":\"true\"}";
        mvc.perform(patch("/passengers/1")
                        .content(updates)
                        .header(HttpHeaders.CONTENT_TYPE,
                                MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(passengerRepository, times(1)).findById(1L);
        verify(passengerRepository, times(1)).save(passenger);
    }

    /**
     * Выполняем операцию DELETE для URL-адреса /passengers/4, проверяет, что возвращено состояние OK,
     * и проверяет, что метод deleteById был выполнен ровно один раз
     */
    @Test
    public void testDeletePassenger() throws Exception {
        mvc.perform(delete("/passengers/4"))
                .andExpect(status().isOk());
        verify(passengerRepository, times(1)).deleteById(4L);
    }

}
