package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Test Check Class
 *
 * @author Misha Shirinkin (misha.shirinkin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class CheckTest {

    /**
     * Тестируем монопоследовательность нечетную
     */
    @Test
    public void whenDataMonoByTrueThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, true, true};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * Тестируем НЕ монопоследовательность нечетную
     */
    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, false, true};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    /**
     * Тестируем монопоследовательность четную
     */
    @Test
    public void whenDatatMonoBy4True() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, true, true, true};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * Тестируем НЕ монопоследовательность четную
     */
    @Test
    public void whenDataNotMonoByTrueThenFalse4Counts() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, false, true, false};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }
}