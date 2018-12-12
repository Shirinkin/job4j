package lambda;

import org.junit.Test;

import java.util.List;
import java.util.function.Function;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class DiapasonTest {

    @Test
    public void whenSqareFunc() {
        Function<Double, Double> func = x -> x * x;
        Diapason diapason = new Diapason();
        List<Double> result = diapason.diapasonCalc(0, 3, func);
        assertThat(result.get(1), is((double) 1));

    }

    @Test
    public void whenLinearFunc() {
        Function<Double, Double> func = x -> x;
        Diapason diapason = new Diapason();
        List<Double> result = diapason.diapasonCalc(0, 5, func);
        assertThat(result.get(4), is((double) 4));

    }

    @Test
    public void whenLogFunc() {
        Function<Double, Double> func = x -> Math.log(x);
        Diapason diapason = new Diapason();
        List<Double> result = diapason.diapasonCalc(0, 11, func);
        assertThat(result.get(1), is((double) 0));

    }

}