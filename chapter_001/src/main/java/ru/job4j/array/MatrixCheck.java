package ru.job4j.array;

/**
 * 6.7. Квадратный массив заполнен true или false по диагоналям.[#86127]
 * @author Misha shirinkin (Misha.shirinkin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class MatrixCheck {

    /**
     * Метод проверяет элементы матрицы по диагонали
     * @param data
     * @return true если диагональ матрицы состоит из одинаковых элементов
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i][i] != data[i + 1][i + 1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
