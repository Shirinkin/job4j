package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Test FindLoop Class
 *
 * @author Misha Shirinkin (misha.shirinkin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class FindLoopTest {

    /**
     * Тестирем метод indexOf класса FindLoop
     * ищем элемент 5, получаем индекс элемента 0
     */
    @Test
    public void whenArrayHasLengh5Then0() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 3};
        int value = 5;
        int result = find.indexOf(input, value);
        int expect = 0;
        assertThat(result, is(expect));
    }

    /**
     * Тестирем метод indexOf класса FindLoop
     * ищем элемент 13, получаем индекс элемента 4
     */
    @Test
    public void whenArray13then4() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 3, 0, 13};
        int value = 13;
        int result = find.indexOf(input, value);
        int expect = 4;
        assertThat(result, is(expect));
    }

    /**
     * Тестирем метод indexOf класса FindLoop
     * ищем элемент 158, получаем индекс элемента -1
     */
    @Test
    public void whenArray158thenMinusOne() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 3, 0, 13};
        int value = 158;
        int result = find.indexOf(input, value);
        int expect = -1;
        assertThat(result, is(expect));
    }
}