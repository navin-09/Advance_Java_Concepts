package CollectionsDemo.LinkedHashSet;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetDemo {
    public static void main(String[] args) {
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Apple");
        linkedHashSet.add("Banana");
        linkedHashSet.add("Mango");
        System.out.println("Fruits in LinkedHashSet: " + linkedHashSet);
        linkedHashSet.add("Apple"); // Duplicate, won't be added
        System.out.println("After adding duplicate Apple: " + linkedHashSet);   
        
    }
}
