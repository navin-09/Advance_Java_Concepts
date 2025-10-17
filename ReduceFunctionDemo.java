import java.util.List;

public class ReduceFunctionDemo {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        System.out.println("==== SUM OPERATION ====");

        int sum = numbers.stream()
                .reduce(0, (a, b) -> {
                    System.out.println("a = " + a + ", b = " + b + " → (a + b) = " + (a + b));
                    return a + b;
                });

        System.out.println("Sum of numbers: " + sum);

        System.out.println("\n==== MAX OPERATION ====");

        int max = numbers.stream()
                .reduce(Integer.MIN_VALUE, (a, b) -> {
                    int result = a > b ? a : b;
                    System.out.println("a = " + a + ", b = " + b + " → max = " + result);
                    return result;
                });

        System.out.println("Maximum number: " + max);
    }
}
