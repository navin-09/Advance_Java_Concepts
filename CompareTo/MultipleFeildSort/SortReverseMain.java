package CompareTo.MultipleFeildSort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortReverseMain {
    public void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Apple", 1.99),
                new Product("Banana", 0.99),
                new Product("Orange", 1.99),
                new Product("Mango", 2.49));

        products.sort(
                Comparator.comparing(Product::getPrice, Comparator.reverseOrder())
                        .thenComparing(Product::getName));

        // Display sorted list
        System.out.println(products);
    }
}
