package CompareTo.MultipleFeildSort;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Apple", 1.99),
            new Product("Banana", 0.99),
            new Product("Orange", 1.99),
            new Product("Mango", 2.49)
        );

        // ✅ Sort by price, then by name
        products.sort(
            Comparator
                .comparing(Product::getPrice)
                .thenComparing(Product::getName)
        );

        // Display sorted list
        System.out.println(products);
    }
}
