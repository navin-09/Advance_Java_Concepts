package CollectionsDemo.HashMap;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        Map<String , Integer> hashMap = new HashMap<>();
        hashMap.put("one", 1);
        hashMap.put("two", 2);
        hashMap.put("three", 3);
        System.out.println("HashMap contents: " + hashMap);

        hashMap.put("two", 22); // Update value for key "two"
        System.out.println("After updating key 'two': " + hashMap);

        hashMap.remove("one");
        System.out.println("After removing key 'one': " + hashMap);

        System.out.println("keys"+hashMap.keySet());

        System.out.println("values"+hashMap.values());

    }
    
}
