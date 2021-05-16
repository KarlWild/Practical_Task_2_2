package ru.netcracker.task_3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadOracleDoc {
    public static FileWriter fromRead(FileReader fileReader) throws IOException {
        FileWriter fileWriter = null;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        try{
            fileWriter = new FileWriter("C:\\Users\\KarlWild\\IdeaProjects\\Practical_Task_2_2\\src\\ru\\netcracker\\task_3\\text.txt");
            int c;
            while ((c = fileReader.read()) != -1 && count!=3) {
                if(c!=32){
                    fileWriter.write(c);
                    sb.append(Character.toChars(c));
                }
                else {
                    if(sb.toString().toLowerCase().contains("java")) count++;
                    sb = new StringBuilder();
                    fileWriter.write(c);
                }
            }
        }
        finally {
            if (fileReader != null) {
                fileReader.close();
            }
            if (fileWriter != null) {
                fileWriter.close();
            }
        }
        return fileWriter;
    }
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("C:\\Users\\KarlWild\\IdeaProjects\\Practical_Task_2_2\\src\\ru\\netcracker\\task_3\\javaDoc.txt");
        System.out.println(fromRead(fileReader).toString());
    }
}
