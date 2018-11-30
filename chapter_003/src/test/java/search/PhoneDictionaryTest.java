package search;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        PhoneDictionary phoneDictionary = new PhoneDictionary();
        phoneDictionary.add(new Person("Misha", "Shirinkin", "8954", "Pushkin"));
        List<Person> personList = phoneDictionary.find("Misha");
        assertThat(personList.iterator().next().getSurname(), is("Shirinkin"));
    }

}