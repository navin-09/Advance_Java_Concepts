package GenericsDemo.GenericBoundedType;

public class Main {
    public static void main(String[] args) {
        Calculator<Integer> c1 = new Calculator<>(5, 10);
        Calculator<Double> c2 = new Calculator<>(2.5, 3.7);

        System.out.println(c1.add()); // 15.0
        System.out.println(c2.add()); // 6.2
        // Calculator<String> c3 = new Calculator<>("a", "b"); ❌ Compile-time error
    }
}