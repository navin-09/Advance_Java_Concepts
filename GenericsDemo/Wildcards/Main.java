package GenericsDemo.Wildcards;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        PrintList printList = new PrintList();
        List<Integer> intList = List.of(1, 2, 3);
        List<Double> doubleList = List.of(1.1, 2.2, 3.3);
        printList.print(intList);
        printList.print(doubleList);
    }

}
