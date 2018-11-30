package map;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class UserConvertTest {


    @Test
    public void whenConvert() {
        UserConvert convert = new UserConvert();
        List<User> result = new ArrayList<>();
        User user1 = new User("tem",1,"erterterte");
        result.add(new User("sdf",5,"234"));
        result.add(user1);
        result.add(new User("Misha",15,"SPB"));
        HashMap<Integer, User> temp = convert.process(result);
        assertThat(temp.get(1), is(user1));

    }
}