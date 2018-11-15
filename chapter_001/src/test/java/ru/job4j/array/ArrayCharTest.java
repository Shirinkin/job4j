package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Тестирование класса ArrayChar
 */
public class ArrayCharTest {

    /**
     * Если есть совпадения
     */
    @Test
    public void whenStartWithPrefixThenTrue() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.startWith("He");
        assertThat(result, is(true));
    }

    /**
     * Если совпадений нет
     */
    @Test
    public void whenNotStartWithPrefixThenFalse() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.startWith("Hi");
        assertThat(result, is(false));
    }

    /**
     * Точное совпадение слова
     */
    @Test
    public void whenStartWithPrefixAndConditionsAreEquals() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.startWith("Hello");
        assertThat(result, is(true));
    }
}