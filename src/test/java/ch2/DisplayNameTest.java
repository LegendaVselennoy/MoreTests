package ch2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test.ch2.SUT;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тестовый класс, показывающий аннотацию @DisplayName")
public class DisplayNameTest {

    private SUT systemUnderTest=new SUT();

    @Test
    @DisplayName("Наша тестируемая система передает привет")
    void testHello(){
        assertEquals("Привет!",systemUnderTest.hello());
    }

    @Test
    @DisplayName("😱")
    void testTalking() {
        assertEquals("Как дела?", systemUnderTest.talk());
    }

    @Test
    void testBye() {
        assertEquals("Пока!", systemUnderTest.bye());
    }

}
