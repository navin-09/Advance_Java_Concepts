package GenericsDemo.GenericClass;

public class Main {
    public static void main(String[] args) {
        Box<String> stringBox = new Box<>();
        stringBox.set("String Type Box "+" Hello Generics");
        System.out.println(stringBox.get());

        Box<Integer> intBox = new Box<>();
        intBox.set(42);
        System.out.println("String Type Box " +intBox.get());
    }
}