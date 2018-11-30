package comparator;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        final int minlength = Math.min(o1.length(), o2.length());
        int compareResult = 0;
        for (int i = 0; i != minlength; i++) {
            compareResult = Character.compare(o1.charAt(i), o2.charAt(i));
            if (compareResult != 0) {
                break;
            }
        }
        return compareResult != 0 ? compareResult : Integer.compare(o1.length(), o2.length());
    }
}
