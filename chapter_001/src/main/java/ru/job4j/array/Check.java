package ru.job4j.array;

/**
 * Массив заполнен true или false[#86126]
 * @author Misha shirinkin (Misha.shirinkin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Check {

    /**
     * Проверяет является ли последовательность моно
     * @param data - массив с последовательностью
     * @return true если монопоследовательность, false если не монопоследовательность
     */
    public boolean mono(boolean[] data) {
        boolean result = false;
        boolean prevdata = data[0];
        for (int index = 0; index < data.length; index++) {
            if (data[index] != prevdata) {
                result = false;
                break;
            } else {
                result = true;
            }
        }
        return result;
    }
}