package CollectionsDemo.TreeSet;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {

        Set<String> treeSet = new TreeSet<>();

        treeSet.add("Orange");
        treeSet.add("Apple");
        treeSet.add("Banana");
        System.out.println("Fruits in TreeSet (sorted): " + treeSet);
        
        treeSet.add("Apple"); // Duplicate, won't be added
        System.out.println("After adding duplicate Apple: " + treeSet);

    }
}
