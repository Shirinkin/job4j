package ru.job4j.loop;

/**
 * Рисовальщик доски
 * @author Misha shirinkin (Misha.shirinkin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Board {

    /**
     * метод рисует доску
     * @param width Ширина поля
     * @param height Высота поля
     * @return возвращает доску
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int sizeHeight = 1; sizeHeight <= height; sizeHeight++) {
            for (int sizeWidth = 1; sizeWidth <= width; sizeWidth++) {
                if ((sizeHeight + sizeWidth) % 2 == 0) {
                    screen.append("x");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}
