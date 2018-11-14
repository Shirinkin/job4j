package ru.job4j.max;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Misha shirinkin (Misha.shirinkin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class MaxTest {

    /**
     * Test method max(), when 2nd more then 1st
     */
    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }

    /**
     * Test 2 constructor of max(), when 2nd more then 1st
     */
    @Test
    public void whenThreeCounts() {
        Max maxim = new Max();
        int result = maxim.max(1, 2,4);
        assertThat(result, is(4));
    }
}