package ExceptionHandling;

public class TryCatchFinallyDemo {
    public static void main(String[] args) {
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]); // ❌ ArrayIndexOutOfBounds
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught exception: " + e.getMessage());
        } finally {
            System.out.println("Finally block always runs!");
        }

        System.out.println("Program continues...");
    }
}

