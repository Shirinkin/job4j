package list;

import java.util.ArrayList;
import java.util.List;

/**
 * автор - Ширинкин Михаил
 */
public class ConvertMatrix2List {

    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] ints : array) {
            for (int intsa : ints) {
                list.add(intsa);
            }
        }

        return list;
    }
}
