package ch2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestReporter;
import test.ch1.Calculator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepeatedTestsTest {

    private static Set<Integer> integerSet = new HashSet<>();
    private static List<Integer> integerList = new ArrayList<>();

    @RepeatedTest(value = 5, name =
            "{displayName} - repetition {currentRepetition}/{totalRepetitions}")
    /**
     * {displayName} - Отображаемое имя метода с аннотацией @RepeatedTest
     * {currentRepetition} - Текущее число повторений
     * {totalRepetitions} - Общее количество повторений
     */
    @DisplayName("Тестовая операция добавления")
    void addNumber() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.add(1, 1), "1 + 1 должно быть равно 2");
    }

    @RepeatedTest(value = 5, name = "список содержит {currentRepetition} элемент(ы), набор содержит 1 элемент")
    void testAddingToCollections(TestReporter testReporter, RepetitionInfo repetitionInfo) {

        integerSet.add(1);
        integerList.add(repetitionInfo.getCurrentRepetition());
        testReporter.publishEntry("Номер повторения", String.valueOf(repetitionInfo.getCurrentRepetition()));
        assertEquals(1, integerSet.size());
        assertEquals(repetitionInfo.getCurrentRepetition(),
                integerList.size());

    }

}
