package javaOptionals;

import java.util.Optional;

// optionals lesson from Amigoscode on YT

public class optionalMethods {

    public static void main(String[] args) {

        /* Old way of handling NullPointerExceptions

        String email = null;
        if (person.getEmail() != null) {
            email = email.toLowerCase();
        } else {
            // default behavior
        }

         */

        /*
        Benefits of optionals:
        - Declarative programming
        - Clarifies intent
        - Removes uncertainty
        - Functional programming
         */

        // Optional.of() -> you know that the value will not be null
        // Optional.ofNullable() -> not sure if value will be present

        // Methods inside Optional Class
        // Optional<T>.isPresent() -> whether there is a value inside the optional
        // Optional<T>.isEmpty() -> whether optional is empty

        // Example 1
        Optional<Object> empty = Optional.empty();
        System.out.println("print Optional.empty():");
        System.out.println(empty);
        System.out.println();

        System.out.println("isPresent() on empty optional:");
        System.out.println(empty.isPresent());
        System.out.println();

        System.out.println("isEmpty() on empty optional:");
        System.out.println(empty.isEmpty());
        System.out.println();


        // Example 2
        Optional<String> hello = Optional.of("hello");
        String orElse = hello.orElse("world");

        System.out.println("Print Example 2:");
        System.out.println(hello.isPresent());
        System.out.println(hello.isEmpty());
        System.out.println(orElse);
        System.out.println();


        // Example 3
        Optional<String> nullable = Optional.ofNullable(null);
        String orElseNullable = nullable.orElse("world");

        System.out.println("Print Example 3:");
        System.out.println(nullable.isPresent());
        System.out.println(nullable.isEmpty());
        System.out.println(orElseNullable);
        System.out.println();

        // .map() Example
        Optional<String> hello2 = Optional.ofNullable("hello");
        String orElse2 = hello2
                .map(String::toUpperCase)
                .orElse("world");

        System.out.println("Print .map() Example:");
        System.out.println(hello2.isPresent());
        System.out.println(hello2.isEmpty());
        System.out.println(orElse2);
        System.out.println();

        // .orElseGet() Example
        Optional<String> hello3 = Optional.ofNullable(null);
        String orElse3 = hello3
                .map(String::toUpperCase)
                .orElseGet(() -> {
                    // ... extra computation to retrieve the value
                    return "world";
                });

        System.out.println("Print .orElseGet() Example:");
        System.out.println(hello3.isPresent());
        System.out.println(hello3.isEmpty());
        System.out.println(orElse3);
        System.out.println();

        // .or() <- allows you to return an Optional.
        // .orElse() <- allows you to return the data type you started with
        // in this case, a String

        // .orElseThrow() Example
        // use when you know for sure there should be a value
        Optional<String> hello4 = Optional.ofNullable(null);

        /* this will throw an exception
        String orElse4 = hello4
                .map(String::toUpperCase)
                .orElseThrow(IllegalStateException::new);
        */

        System.out.println("Print .orElseThrow() Example:");
        System.out.println(hello4.isPresent());
        System.out.println(hello4.isEmpty());
        // System.out.println(orElse4);
        System.out.println();

        // .ifPresent() Example
        Optional<String> hello5 = Optional.ofNullable(null);

        System.out.println("Print .ifPresent() Example:");
        System.out.println(hello5.isPresent());
        System.out.println(hello5.isEmpty());

        System.out.println("Word prints below if present:");
        hello5.ifPresent(System.out::println);









    }
}
