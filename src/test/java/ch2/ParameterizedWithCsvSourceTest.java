package ch2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import test.ch2.WordCounter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParameterizedWithCsvSourceTest {

    private WordCounter wordCounter=new WordCounter();

    /**
     * Каждая строка CSV анализируется. Первое значение присваивается expected параметру,
     * а второе — параметру sentence
     */
    @ParameterizedTest
    @CsvSource({"2, Unit testing", "3, JUnit in Action",
            "4, Write solid Java code"})
    void testWordsInSentence(int expected, String sentence) {
        assertEquals(expected, wordCounter.countWords(sentence));
    }

}
