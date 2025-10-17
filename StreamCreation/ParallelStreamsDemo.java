package StreamCreation;

import java.util.List;
import java.util.stream.IntStream;

public class ParallelStreamsDemo {
    public static void main(String[] args) {
        List<Integer> numbers = IntStream.rangeClosed(1, 20_000_000)
                .boxed()
                .toList();

        // Sequential Stream
        long start = System.currentTimeMillis();
        long countSequential = numbers.stream()
                .filter(n -> n % 2 == 0)
                .count();
        long end = System.currentTimeMillis();
        System.out.println("Sequential Stream count: " + countSequential);
        System.out.println("Time taken (Sequential): " + (end - start) + " ms");

        // Parallel Stream
        start = System.currentTimeMillis();
        long countParallel = numbers.parallelStream()
                .filter(n -> n % 2 == 0)
                .count();
        end = System.currentTimeMillis();
        System.out.println("\nParallel Stream count: " + countParallel);
        System.out.println("Time taken (Parallel): " + (end - start) + " ms");
    }
}
