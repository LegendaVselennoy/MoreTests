package ch2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import test.ch2.Sentences;
import test.ch2.WordCounter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParameterizedWithEnumSourceTest {

    private WordCounter wordCounter=new WordCounter();

    /**
     * Первый тест помечается как параметризованный.
     * Затем мы указываем источник перечисления как весь класс Sentences.class B.
     * Таким образом, этот тест выполняется три раза, по одному разу для каждого экземпляра перечисления Sentences:
     * JUNIT_IN_ACTION, SOME_PARAMETERS и THREE_PARAMETERS.
     */
    @ParameterizedTest
    @EnumSource(Sentences.class)
    void testWordsInSentence(Sentences sentences){
        assertEquals(3,wordCounter.countWords(sentences.value()));
    }

    /**
     * Затем мы указываем источник перечисления как Sentences.class, но ограничиваем экземпляры, передаваемые в тест,
     * JUNIT_IN_ACTION и THREE_PARAMETERS. Таким образом, этот тест будет выполнен дважды.
     */
    @ParameterizedTest
    @EnumSource(value=Sentences.class,
            names = { "JUNIT_IN_ACTION", "THREE_PARAMETERS" })
    void testSelectedWordsInSentence(Sentences sentence) {
        assertEquals(3, wordCounter.countWords(sentence.value()));
    }


    /**
     * Затем мы указываем источник перечисления как Sentences.class, но исключаем THREE_PARAMETERS экземпляр.
     * Итак, этот тест выполняется дважды: для JUNIT_IN_ACTION и для SOME_PARAMETERS.
     */
    @ParameterizedTest
    @EnumSource(value=Sentences.class, mode = EnumSource.Mode.EXCLUDE, names =
            { "THREE_PARAMETERS" })
    void testExcludedWordsInSentence(Sentences sentence) {
        assertEquals(3, wordCounter.countWords(sentence.value()));
    }

}
