package ch2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test.ch2.Job;
import test.ch2.SUT;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

public class AssertTimeoutTest {

    private SUT systemUnderTest = new SUT("Наша система тестируется");

    @Test
    @DisplayName("Задание выполняется в течение таймаута")
    void testTimeout() throws InterruptedException {
        systemUnderTest.addJob(new Job("Job 1"));
        assertTimeout(ofMillis(500), () -> systemUnderTest.run(200));
    }

    @Test
    @DisplayName("Задание выполняется упреждающе в течение таймаута.")
    void testTimeoutPreemptively() throws InterruptedException {
        systemUnderTest.addJob(new Job("Job 1"));
        assertTimeoutPreemptively(ofMillis(500),
                () -> systemUnderTest.run(200));
    }

}
