package sort;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class UserSort {

    public Set<User> sort (List<User> list) {
        return new TreeSet<>(list);
    }
}
