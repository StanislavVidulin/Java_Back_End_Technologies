import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Jack", 20));
        persons.add(new Person("Anna", 22));
        persons.add(null);
        persons.add(new Person("Igor", 19));
        persons.add(new Person("Mike", 24));
        persons.add(new Person("Nick", 23));

        System.out.println(ifPersonWithNameExists2(persons, "igor")); // true
        System.out.println(ifPersonWithNameExists2(persons, "lena")); // false
        

    }

    public static boolean ifPersonWithNameExists(List<Person> list, String name) {
        for (Person person : list) {
            if (person.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public static boolean ifPersonWithNameExists2(List<Person> list, String name) {
        return list.stream()
                .filter(p -> p!=null) // страхуем от null
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .count() > 0;
    }


    public static boolean ifPersonWithNameExists3(List<Person> list, String name) {
        return list.stream()
                .anyMatch(p -> p.getName().equalsIgnoreCase(name));
    }
}