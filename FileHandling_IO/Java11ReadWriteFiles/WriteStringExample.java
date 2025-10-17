package FileHandling_IO.Java11ReadWriteFiles;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriteStringExample {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get("java11_output.txt");
        String text = "Hello, world!\nWritten with Files.writeString()";
        Files.writeString(path, text);
        System.out.println("✅ File written!");
    }
}
