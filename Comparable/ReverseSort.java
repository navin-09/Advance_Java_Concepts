package Comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseSort {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 35));

        people.sort(Collections.reverseOrder());

        
        System.out.println(people);
    }
}
