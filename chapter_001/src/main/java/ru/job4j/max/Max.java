package ru.job4j.max;


/**
 * @author Misha shirinkin (Misha.shirinkin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Max {

    /**
     * Сравнивает два числа
     * @param first first count
     * @param second second count
     * @return return maximum count
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }
}
