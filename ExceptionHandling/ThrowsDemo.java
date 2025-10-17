package ExceptionHandling;

import java.io.FileReader;
import java.io.IOException;

public class ThrowsDemo {
    static void readFile() throws IOException {
        FileReader fr = new FileReader("file.txt");
    }

    public static void main(String[] args) {
        try {
            readFile();
        } catch (IOException e) {
            System.out.println("Handled IOException in main()");
        }
    }
}
