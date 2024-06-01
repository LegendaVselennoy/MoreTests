package ch2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test.ch2.NoJobException;
import test.ch2.SUT;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class AssertThrowsTest {

    private SUT systemUnderTest = new SUT("Наша система тестируется");

    @Test
    @DisplayName("An exception is expected")
    void testExpectedException() {
        assertThrows(NoJobException.class, systemUnderTest::run);
    }

    @Test
    @DisplayName("Исключение поймано")
    void testCatchException() {
        Throwable throwable = assertThrows(NoJobException.class,
                () -> systemUnderTest.run(1000));
        assertEquals("В списке выполнения нет заданий!",
                throwable.getMessage());
    }

}
