package FileHandling_IO.ioReadWriteExample;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileExample {
    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            writer.write("Hello, Java I/O!");
            writer.newLine();
            writer.write("This is written using BufferedWriter.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

