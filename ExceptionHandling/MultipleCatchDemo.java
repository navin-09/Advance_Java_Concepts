package ExceptionHandling;

public class MultipleCatchDemo {
    public static void main(String[] args) {
        try {
            int[] arr = new int[2];
            arr[5] = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic error!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index issue!");
        } catch (Exception e) {
            System.out.println("General exception!");
        }
    }
}
