package ru.job4j.loop;


import java.util.function.BiPredicate;

/**
 * Рисовальщик треугольника
 * @author Misha shirinkin (Misha.shirinkin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Paint {

    /**
     *
     * @param height - высота пирамиды
     * @param weight - ширина пирамиды
     * @param predict - условия проставления галки
     * @return
     */

    private String loopBy(int height, int weight, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (predict.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
    /**
     * Рисует правосторонний треугольник
     * @param height - высота
     * @return - правосторонний треугольник
     */
    public String rightTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= column
        );
    }

    /**
     * Строит левосторонний треугольник
     * @param height - высота
     * @return левосторонний треугольник
     */
    public String leftTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= height - column - 1
        );
    }

    /**
     * Строит треугольник в итоге
     * @param height - высота
     * @return треугольник
     */
    public String pyramid(int height) {
        return this.loopBy(
                height,
                2 * height - 1,
                (row, column) -> row >= height - column - 1 && row + height - 1 >= column
        );
    }



}
