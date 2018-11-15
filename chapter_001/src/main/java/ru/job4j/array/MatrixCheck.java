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
        int last = data[0].length - 1;
        for (int i = 0; i < last; i++) {
            if (data[i][i] != data[i + 1][i + 1] || data[i][last - i] != data[i + 1][last - i - 1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
