package search;

import java.util.ArrayList;
import java.util.List;

public class PhoneDictionary {

    private List<Person> persons = new ArrayList<Person>();

    /**
     * Добавление нового адресата
     *
     * @param person
     */
    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Поиск в коллекции
     * @param key
     * @return
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (Person person : persons){
            if(person.getAddress().contains(key)||person.getName().contains(key)||person.getPhone().contains(key)||
            person.getSurname().contains(key)) {
                result.add(person);
            }
        }
        return result;
    }
}
