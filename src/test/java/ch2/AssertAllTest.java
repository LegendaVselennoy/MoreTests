package ch2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test.ch2.SUT;

import static org.junit.jupiter.api.Assertions.*;

public class AssertAllTest {

    @Test
    @DisplayName("SUT по умолчанию не должен проходить текущую проверку.")
    void testSystemNotVerified() {

        SUT systemUnderTest = new SUT("Наша система тестируется");
        assertAll("По умолчанию SUT не находится на текущей проверке.",
                () -> assertEquals("Наша система тестируется",
                        systemUnderTest.getSystemName()),
                () -> assertFalse(systemUnderTest.isVerified())
        );

    }


    @Test
    @DisplayName("SUT должен находиться на текущей проверке")
    void testSystemUnderVerification() {
        SUT systemUnderTest = new SUT("Наша система тестируется");
        systemUnderTest.verify();
        assertAll("SUT находится на текущей проверке",
                () -> assertEquals("Наша система тестируется",
                        systemUnderTest.getSystemName()),
                () -> assertTrue(systemUnderTest.isVerified())
        );
    }


    @Test
    @DisplayName("SUT не должен проходить текущую проверку")
    void testSystemNotUnderVerification() {
        SUT systemUnderTest = new SUT("Наша система тестируется");
        assertFalse(systemUnderTest.isVerified(),
                () -> "Система не должна находиться на проверке.");
    }


    @Test
    @DisplayName("У SUT не должно быть текущей работы")
    void testNoJob() {
        SUT systemUnderTest = new SUT("Наша система тестируется");
        assertNull(systemUnderTest.getCurrentJob(),
                () -> "Не должно быть текущей работы");
    }

}
