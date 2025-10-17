package GenericsDemo.GenericClass;

// A generic class 'Box' that can store any type T
public class Box<T> {
    private T value; // T = Type parameter

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}
