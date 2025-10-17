package CollectionsDemo.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {
 public static void main(String[] args) {
    List<String> fruits = new ArrayList<>();

    fruits.add("Apple");
    fruits.add("Banana");
    fruits.add("Cherry");
    System.out.println("Fruits: " + fruits);

    fruits.remove("Banana");
    System.out.println("After removal: " + fruits);
    
    System.out.println("Contains Apple? " + fruits.contains("Apple"));
 }   
}
