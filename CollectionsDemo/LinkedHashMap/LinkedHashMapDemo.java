package CollectionsDemo.LinkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
    
    public static void main(String[] args) {
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("three", 3);
        linkedHashMap.put("two", 2);
        linkedHashMap.put("one", 1);
        System.out.println("LinkedHashMap contents: " + linkedHashMap);
        linkedHashMap.put("two", 22); // Update value for key "two"
        System.out.println("After updating key 'two': " + linkedHashMap);
        linkedHashMap.remove("one");
        System.out.println("After removing key 'one': " + linkedHashMap);
        System.out.println("keys"+linkedHashMap.keySet());
        System.out.println("values"+linkedHashMap.values());
    }
}
