package ru.netcracker.task_1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CopyingJavaFile {
    public static void main(String[] args) throws IOException {
        String orig = System.getProperty("user.dir");
        orig += "\\src\\ru\\netcracker\\task_1\\CopyingJavaFile.java";
        Path originalPath = Paths.get(orig);
        Path copied = Paths.get("src\\ru\\netcracker\\task_1\\copied_file.java");
        Files.copy(originalPath, copied, StandardCopyOption.REPLACE_EXISTING);
    }
}
