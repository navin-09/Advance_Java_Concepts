package StreamCreation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamCreationDemo {
    public static void main(String[] args) {
        // From a collection
        Stream<String> stream1 = List.of("A", "B", "C").stream();

        // From an array
        Stream<Integer> stream2 = Arrays.stream(new Integer[] { 1, 2, 3 });

        // From static method
        Stream<String> stream3 = Stream.of("Java", "Python", "C++");

        // Infinite stream (generate)
        Stream<Double> randoms = Stream.generate(Math::random).limit(3);
        randoms.forEach(System.out::println);
        stream1.forEach(System.out::println);
        stream2.forEach(System.out::println);
        stream3.forEach(System.out::println);
    }
}
