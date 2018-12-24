package map;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {


    @Test
    public void whenConvert() {
        UserConvert convert = new UserConvert();
        List<User> result = List.of(
                new User("tem", 1, "erterterte"),
                new User("sdf", 5, "234"),
                new User("Misha", 15, "SPB")
        );
        HashMap<Integer, User> temp = convert.process(result);
        assertThat(temp.get(1).getName(), is("tem"));

    }
}