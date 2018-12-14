package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * автор - Ширинкин Михаил
 */
public class ConvertMatrix2List {

    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        Arrays.stream(array).forEach(ar -> Arrays.stream(ar).forEach(list::add));

        return list;
    }
}
