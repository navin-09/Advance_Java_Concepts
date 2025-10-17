package CollectionsDemo.LinkedList;

import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {
    public  static void main(String[] args) {
        List<String> linkedListFruits = new LinkedList<>();

        linkedListFruits.add("Mango");
        linkedListFruits.add("Orange");
        linkedListFruits.add("Grapes");
        System.out.println("Fruits in LinkedList: " + linkedListFruits);

        linkedListFruits.remove("Orange");
        System.out.println("After removal: " + linkedListFruits);

        System.out.println("Contains Mango? " + linkedListFruits.contains("Mango"));
        
        linkedListFruits.addFirst("A");
        linkedListFruits.addLast("Z");
        System.out.println("After adding elements at both ends: " + linkedListFruits);
     
    }
    
}
