package ExceptionHandling;

public class ThrowDemo {
    public static void main(String[] args) {
        int age = 15;

        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18 or older!");
        }

        System.out.println("You can vote!");
    }
}
