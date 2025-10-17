package GenericsDemo.Wildcards;

import java.util.List;

public class PrintList {

    public void print(List<? extends Number> list) {
        for (Number n : list) {
            System.out.println(n);
        }
    }

}
