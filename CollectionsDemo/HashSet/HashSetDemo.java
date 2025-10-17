package CollectionsDemo.HashSet;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {
    public static void main(String[] args) {

        Set<String> hashSetFruits = new HashSet<>();
        hashSetFruits.add("Apple");
        hashSetFruits.add("Banana");
        hashSetFruits.add("Mango");
        System.out.println("Fruits in HashSet: " + hashSetFruits);

        hashSetFruits.add("Apple"); // Duplicate, won't be added
        System.out.println("After adding duplicate Apple: " + hashSetFruits);

        hashSetFruits.remove("Banana");
        System.out.println("After removal: " + hashSetFruits);

        System.out.println("Contains Mango? " + hashSetFruits.contains("Mango"));
    }
}
