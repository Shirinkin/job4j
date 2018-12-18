package sort;


import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class UserSort {

    public Set<User> sort(List<User> list) {
        return new TreeSet<>(list);
    }

    public List<User> sortByNameLength(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                Integer o1name = o1.getName().length();
                Integer o2name = o2.getName().length();
                return o1name.compareTo(o2name);
            }
        });
        return list;
    }

    public List<User> sortByAllFields(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                final int rs = o1.getName().compareTo(o2.getName());
                return rs != 0 ? rs : o1.getAge().compareTo(o2.getAge());
            }
        });
        return list;
    }
}
