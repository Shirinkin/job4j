package sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class UserSortTest {

    @Test
    public void whenSortByName() {
        UserSort sorted = new UserSort();
        List<User> tempList = List.of(
                new User(5, "Misha"),
                new User(50, "Adel"),
                new User(1, "Adel")
        );
        Set<User> result = sorted.sort(tempList);
        assertThat(result.iterator().next().getName(), is("Adel"));
    }

    @Test
    public void whenSortByAge() {
        UserSort sorted = new UserSort();
        List<User> tempList = List.of(
                new User(5, "Misha"),
                new User(50, "Adel"),
                new User(1, "Adel")
        );
        Set<User> result = sorted.sort(tempList);
        System.out.println(result);
        assertThat(result.iterator().next().getName(), is("Adel"));
    }

    @Test
    public void whenSortByNameLength() {
        UserSort sorted = new UserSort();
        List<User> tempList = List.of(
                new User(5, "Misha"),
                new User(50, "Adel"),
                new User(1, "Adel")
        );
        List<User> result = sorted.sortByNameLength(tempList);
        System.out.println(result);
        assertThat(result.iterator().next().getName(), is("Adel"));
    }

    @Test
    public void whenSortByAllFields() {
        UserSort sorted = new UserSort();
        List<User> tempList = List.of(
                new User(5, "Misha"),
                new User(50, "Adel"),
                new User(1, "Adel")
        );
        System.out.println(tempList);
        List<User> result = sorted.sortByAllFields(tempList);
        System.out.println(result);
        assertThat(result.get(1).getName(), is("Misha"));
    }


}