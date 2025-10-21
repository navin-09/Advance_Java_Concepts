package CompareTo;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 35));

        // Sort by name using Comparator
        Collections.sort(people, new PersonNameComparator());
        System.out.println(people);
    }
}
