package FunctionalInterfaces;

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        // Using lambda expressions to define operations
        Calculator addition = (a, b) -> a + b;
        Calculator subtraction = (a, b) -> a - b;
        Calculator multiplication = (a, b) -> a * b;
        Calculator division = (a, b) -> a / b;

        // Performing operations
        int num1 = 20;
        int num2 = 10;

        System.out.println("Addition: " + addition.operate(num1, num2));
        System.out.println("Subtraction: " + subtraction.operate(num1, num2));
        System.out.println("Multiplication: " + multiplication.operate(num1, num2));
        System.out.println("Division: " + division.operate(num1, num2));
    }
    
}
