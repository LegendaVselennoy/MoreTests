package ch2;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import test.ch2.SUT;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DisabledMethodTest {

    private SUT systemUnderTest = new SUT("Наша тестируемая система");

    @Test
    @Disabled
    void testRegularWork() {
        boolean canReceiveRegularWork = systemUnderTest.canReceiveRegularWork();

        assertTrue(canReceiveRegularWork);
    }

    @Test
    @Disabled("Функция все еще в разработке.")
    void testAdditionalWork() {
        boolean canReceiveAdditionalWork = systemUnderTest.canReceiveAdditionalWork();

        assertFalse(canReceiveAdditionalWork);
    }

}
