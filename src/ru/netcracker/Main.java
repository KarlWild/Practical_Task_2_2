package ru.netcracker;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //Path path = Paths.get("/src/ru/netcracker/task_1");
        String s = System.getProperty("user.dir");

        System.out.println(s);
    }
}
