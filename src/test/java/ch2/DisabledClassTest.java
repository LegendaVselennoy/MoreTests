package ch2;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import test.ch2.SUT;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Disabled("Функция все еще находится в стадии разработки")
public class DisabledClassTest {

    private SUT systemUnderTest = new SUT("Наша тестируемая система");

    @Test
    void testRegularWork() {
        boolean canReceiveRegularWork = systemUnderTest.canReceiveRegularWork();

        assertTrue(canReceiveRegularWork);
    }

    @Test
    void testAdditionalWork() {
        boolean canReceiveAdditionalWork = systemUnderTest.canReceiveAdditionalWork();

        assertFalse(canReceiveAdditionalWork);
    }

}
