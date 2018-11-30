package list;

import java.util.Arrays;
import java.util.List;

public class ConvertList2Array {

    /**
     * Метод преобразует лист в двумерный массив
     * @param list
     * @param rows
     * @return
     */
    public int[][] toArray(List<Integer> list, int rows) {

        int cells = (int) Math.ceil((float)list.size() / rows);
        int[][] array = new int[rows][cells];
        int index = 0;
        for (int out = 0; out < rows; out++) {
            for (int in = 0; in < cells; in++) {
                if (index < list.size()) {
                    array[out][in] = list.get(index);
                }
                index++;
            }
        }
        return array;
    }
}
