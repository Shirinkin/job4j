package sort;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class UserSort {

    public Set<User> sort (List<User> list) {
        Set<User> sortedSet = new TreeSet<>();
        for (User user : list) {
            sortedSet.add(user);
        }
        return sortedSet;
    }
}
