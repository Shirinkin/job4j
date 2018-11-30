package sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class UserSortTest {

    @Test
    public void WhenSortByName() {
        UserSort sorted = new UserSort();
        List<User> tempList = new ArrayList<>();
        User user1 = new User(5, "Misha");
        User user2 = new User(15, "Adel");
        User user3 = new User(1500, "Yasha");
        tempList.add(user1);
        tempList.add(user2);
        tempList.add(user3);
        Set<User> result = sorted.sort(tempList);
        assertThat(result.iterator().next(), is(user1));
    }

    @Test
    public void WhenSortByAge() {
        UserSort sorted = new UserSort();
        List<User> tempList = new ArrayList<>();
        User user1 = new User(5, "Misha");
        User user2 = new User(5, "Adel");
        User user3 = new User(1, "Adel");
        tempList.add(user1);
        tempList.add(user2);
        tempList.add(user3);
        System.out.println(tempList);
        Set<User> result = sorted.sort(tempList);
        System.out.println(result);
        assertThat(result.iterator().next(), is(user3));
    }
}