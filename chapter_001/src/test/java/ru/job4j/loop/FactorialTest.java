package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * @author Misha shirinkin (Misha.shirinkin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class FactorialTest {

    /**
     * Test for calc method when add 5
     */
    @Test
    public void whenAdd5Then120() {
        Factorial factorial = new Factorial();
        double result = factorial.calc(5);
        double expected = 120;
        assertThat(result, is(expected));
    }

    /**
     * Test for calc method when add 0
     */
    @Test
    public void whenAdd0Then1() {
        Factorial factorial = new Factorial();
        double result = factorial.calc(0);
        double expected = 1;
        assertThat(result, is(expected));
    }
}
