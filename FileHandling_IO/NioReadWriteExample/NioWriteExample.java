package FileHandling_IO.NioReadWriteExample;

import java.nio.file.*;
import java.io.IOException;
import java.util.List;

public class NioWriteExample {
    public static void main(String[] args) {
        try {
            Path path = Paths.get("nio_output.txt");
            List<String> data = List.of("Line 1", "Line 2", "Line 3");
            Files.write(path, data);
            System.out.println("✅ File written successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
