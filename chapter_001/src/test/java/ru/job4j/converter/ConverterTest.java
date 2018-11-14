package ru.job4j.converter;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Misha Shirinkin (misha.shirinkin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ConverterTest {

    /**
     * Test rubleToDollar
     */
    @Test
    public void when60RubleToDollarThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToDollar(60);
        assertThat(result, is(1));
    }

    /**
     * Test rubleToEuro
     */
    @Test
    public void when70RubleToEuroThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToEuro(70);
        assertThat(result, is(1));
    }

    /**
     * Test euroToRub
     */
    @Test
    public void when1DollarToEuroThen70() {
        Converter converter = new Converter();
        int result = converter.euroToRub(1);
        assertThat(result, is(70));
    }

    /**
     * Test dollarToRub
     */
    @Test
    public void when1EuroToRubThen60() {
        Converter converter = new Converter();
        int result = converter.dollarToRub(1);
        assertThat(result, is(60));
    }
}
