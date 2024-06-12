package ch17;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import test.ch16.Passenger;
import test.ch16.PassengerRegistrationEvent;
import test.ch16.RegistrationManager;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest()
@Import({TestBeans.class})
//@EnableAutoConfiguration
//@ImportResource("classpath:application-context.xml")
public class RegistrationTest {

    @Autowired
    private Passenger passenger;

    @Autowired
    private RegistrationManager registrationManager;

//    @Test
//    void testPersonRegistration() {
//        registrationManager.getApplicationContext().publishEvent(new PassengerRegistrationEvent(passenger));
//        System.out.println("After registering:");
//        System.out.println(passenger);
//        assertTrue(passenger.isRegistered());
//    }

    @Test
    void testPersonRegistration() {
        registrationManager.getApplicationContext()
                .publishEvent(new PassengerRegistrationEvent(passenger));
        System.out.println("After registering:");
        System.out.println(passenger);
        assertTrue(passenger.isRegistered());
    }

}
