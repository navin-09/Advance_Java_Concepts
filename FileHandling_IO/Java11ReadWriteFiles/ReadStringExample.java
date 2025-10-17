package FileHandling_IO.Java11ReadWriteFiles;

import java.nio.file.Files;
import java.nio.file.Path;

public class ReadStringExample {
    public static void main(String[] args) throws Exception {
        String content = Files.readString(Path.of("java11_output.txt"));
        System.out.println(content);
    }
}
