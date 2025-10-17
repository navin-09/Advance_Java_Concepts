package CollectionsDemo.TreeMap;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("three", 3);
        treeMap.put("two", 2);
        treeMap.put("one", 1);
        System.out.println("TreeMap contents (sorted by keys): " + treeMap);

        treeMap.put("two", 22); // Update value for key "two"
        System.out.println("After updating key 'two': " + treeMap);

        treeMap.remove("one");
        System.out.println("After removing key 'one': " + treeMap);
        System.out.println("keys" + treeMap.keySet());
        System.out.println("values" + treeMap.values());

    }
}
