package ru.job4j.array;

/**
 * Удаляет дубликаты из массива
 */
public class ArrayDuplicate {

    public String[] remove (String [] array){
        int duplicate = array.length;
        for (int out = 0; out < duplicate; out++){
            String temp = array[out];
            for (int in = 0; in < duplicate; in++){
                if (temp.equals(array[in])){
                    array[in] = array[duplicate - 1];
                    duplicate--;
                }
            }
        }
        return array;
    }

}
