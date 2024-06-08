package ch2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import test.ch2.WordCounter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParameterizeWithValueSourceTest {

    private WordCounter wordCounter=new WordCounter();

    @ParameterizedTest
    @ValueSource(strings = {"Проверьте три параметра", "JUnit in Action"})
    void testWordsInSentence(String sentence){
        assertEquals(3,wordCounter.countWords(sentence));
    }
}
