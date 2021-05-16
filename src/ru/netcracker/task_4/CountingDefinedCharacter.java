package ru.netcracker.task_4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CountingDefinedCharacter {
    public static int countingCharacter(char a, FileReader in) {
        int code = (int) a;
        int count = 0;
        try{
            int c;
            while ((c = in.read())!=-1){
                if(c==code) count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }
    public static void main(String[] args) throws FileNotFoundException {
        FileReader in = new FileReader("src/ru/netcracker/task_3/javaDoc.txt");
        System.out.println(countingCharacter(args[0].charAt(0),in));
    }
}
