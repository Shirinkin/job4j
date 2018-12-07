package department;

import java.util.ArrayList;
import java.util.List;


/**
 * Реализует возможность сортировки массива кодов подразделений по возрастанию и убыванию,
 * при которых сохранялась бы иерархическая структура (показано далее в примерах сортировки), т.к.
 * отсортированный массив используется для отображения категорий пользователю.
 */
public class DepartmentSort {

    public static List<String> names = new ArrayList<>();

    /**
     * Заполняем список элементами
     * @return
     */
    public List<String> addValues() {
        names.add("K1/SK1");
        names.add("K1/SK2");
        names.add("K1/SK1/SSK1");
        names.add("K1/SK1/SSK2");
        names.add("K2");
        names.add("K2/SK1/SSK1");
        names.add("K2/SK1/SSK2");
        return names;
    }

    /**
     * Печатает несортированные данные
     */
    public void pritUnsortVal() {
        for (String name : names) {
            System.out.println(name);
        }
    }



    public static void main(String[] args) {
        DepartmentSort departmentSort = new DepartmentSort();
        departmentSort.addValues();
        departmentSort.pritUnsortVal();
        //departmentSort.findSymbols();
    }
}
