package javaOptionals;

/*

 Optionals are a better way to handle a situation where
 a method might not have a value to return.

 The main purpose of an optional is to explicitly tell the user of a method
 that the value they're looking for might not exist and they have to account
 for that possibility.

 If the method returns a value, it'll put the value inside an Optional and
 return it.

 When to use optionals:
 Use them as a return type when your method has the possibility of returning null.
 Tell the user of that method that the value that they're looking for might not exist.

*/

import java.util.Optional;

public class optionalTutorial {

    public static void main(String[] args) {

        Optional<Cat> optionalCat = findCatByName("Fred");

        Cat myCat = optionalCat.orElse(new Cat("UNKNOWN", 0));
        System.out.println(myCat.getName());

        Optional<Cat> optionalCat2 = findCatByName("George");
        optionalCat2.map(Cat::getAge)
                .orElse(0);
    }
    
    private static Optional<Cat> findCatByName (String name) {
        Cat cat = new Cat(name, 3);
        return Optional.ofNullable(cat);
        // if this method returns null, optionals can deal with it
    }
}
