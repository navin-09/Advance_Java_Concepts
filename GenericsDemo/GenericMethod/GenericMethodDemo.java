package GenericsDemo.GenericMethod;

public class GenericMethodDemo {
    // <T> declares a generic type parameter for this method
    public static <T> void printTwice(T value) {
        System.out.println(value);
        System.out.println(value);
    }

    public static void main(String[] args) {
        printTwice("Hello");
        printTwice(123);
        printTwice(3.14);
    }
}
