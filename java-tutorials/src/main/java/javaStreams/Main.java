package javaStreams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

// practicing streams lesson from Amigoscode on YT

public class Main {

    public static void main(String[] args) {

        List<Person> people = getPeople();

        // Imperative approach ❌
        /*
        List<Person> females = new ArrayList<>();
        for (Person person : people) {
          if (person.getGender().equals(Gender.FEMALE)) {
            females.add(person);
          }
        }
        females.forEach(System.out::println);
        */

        // Declarative approach ✅

        // Filter
        List<Person> females = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());

        System.out.println("Filter Females Only");
        females.forEach(System.out::println);
        System.out.println();

        // Sort
        List<Person> sorted = people.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .collect(Collectors.toList());

        List<Person> sortedReverse = people.stream()
                .sorted(Comparator
                        .comparing(Person::getAge)
                        .reversed())
                .collect(Collectors.toList());

        List<Person> sortedAgeGender = people.stream()
                .sorted(Comparator
                        .comparing(Person::getGender)
                        .thenComparing(Person::getAge))
                .collect(Collectors.toList());

        System.out.println("Sorted by Age");
        sorted.forEach(System.out::println);
        System.out.println();
        System.out.println("Sorted by Age Reversed");
        sortedReverse.forEach(System.out::println);
        System.out.println();
        System.out.println("Sorted by Gender then Age");
        sortedAgeGender.forEach(System.out::println);
        System.out.println();

        // All match
        boolean allMatch = people.stream()
                .allMatch(person -> person.getAge() > 5);

        System.out.println("Is every person older than 5");
        System.out.println(allMatch);
        System.out.println();

        // Any match
        boolean anyMatch = people.stream()
                .anyMatch(person -> person.getAge() > 8);

        System.out.println("Is one person older than 8");
        System.out.println(anyMatch);
        System.out.println();

        // None match
        boolean noneMatch = people.stream()
                .noneMatch(person -> person.getName().equals("Antonio"));

        System.out.println("Is no one named Antonio");
        System.out.println(noneMatch);
        System.out.println();

        // Max
        System.out.println("Get oldest person");
        people.stream()
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(person -> System.out.println(person));
        System.out.println();

        // Min
        System.out.println("Get youngest person");
        people.stream()
                .min(Comparator.comparing(Person::getAge))
                .ifPresent(person -> System.out.println(person));
        System.out.println();

        // Group
        Map<Gender, List<Person>> groupByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));

        System.out.println("Group by gender (creates Map<Gender, List<Person>>)");
        groupByGender.forEach((gender, peopleList) -> {
            System.out.println(gender);
            peopleList.forEach(System.out::println);
        });
        System.out.println();

        System.out.println("Print oldest Female");
        people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(person -> System.out.println(person.getName()));
        System.out.println();

        System.out.println("Print oldest Male");
        Optional<String> oldestMale = people.stream()
                .filter(person -> person.getGender().equals(Gender.MALE))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName);

        oldestMale.ifPresent(System.out::println);
        
    }

    private static List<Person> getPeople() {
        return List.of(
                new Person("Antonio", 20, Gender.MALE),
                new Person("Alina Smith", 33, Gender.FEMALE),
                new Person("Helen White", 57, Gender.FEMALE),
                new Person("Alex Boz", 14, Gender.MALE),
                new Person("Jamie Goa", 99, Gender.MALE),
                new Person("Anna Cook", 7, Gender.FEMALE),
                new Person("Zelda Brown", 120, Gender.FEMALE)
        );
    }
}
