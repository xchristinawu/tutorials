package methodReference;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// practicing method references lesson from Aneesh Mistry on YT

public class Application {

    public static void main(String[] args) {
        Person a = new Person("Albus", 150);
        Person b = new Person("Bellatrix", 40);
        Person c = new Person("Cornelius", 70);
        Person d = new Person("Draco", 15);

        List<Person> personList = Arrays.asList(a,b,c,d);

        // Example 1
        personList.forEach(person -> System.out.println(person));
        personList.forEach(System.out::println); // method reference does same thing as lamda expression

        // Example 2 (Class method)
        personList.stream()
                .map(person -> person.getAge())
                .forEach(System.out::println);

        personList.stream()
                .map(Person::getAge)
                .forEach(System.out::println);

        // Example 3 (Constructor)
        List<String> names = Arrays.asList("Daniel", "Rupert", "Emma");

        List<Person> newPersonList = names.stream()
                .map(name -> new Person(name))
                .collect(Collectors.toList());

        List<Person> newPersonList2 = names.stream()
                .map(Person::new)
                .collect(Collectors.toList());

        // Example 4 (Class instance)
        personList.forEach(a::printMyName); // prints "Albus" 4 times

    }
}
