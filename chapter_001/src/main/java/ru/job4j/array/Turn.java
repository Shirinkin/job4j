package ru.job4j.array;
/**
 * Переворот массива
 * @author Misha shirinkin (Misha.shirinkin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Turn {

    /**
     * Метод разворачивает массив
     * @param array - входной массив
     * @return - перевернутый массив
     */
    public int[] back(int[] array) {
        int countOfIteration = Math.round(array.length / 2);
        for (int index = 0; index < countOfIteration; index++) {
            int temp1 = array[index];
            int temp2 = array[array.length - index - 1];
            array[index] = temp2;
            array[array.length - index - 1] = temp1;
        }
        return array;
    }
}
