package GenericsDemo.GenericBoundedType;

public class Calculator<T extends Number> { // only Number or its subclasses
    private T num1, num2;

    public Calculator(T num1, T num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public double add() {
        return num1.doubleValue() + num2.doubleValue();
    }
}
