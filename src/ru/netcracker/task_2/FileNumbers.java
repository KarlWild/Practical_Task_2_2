package ru.netcracker.task_2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileNumbers {
    /**
     * Записывает в файл данные из консоли
     * @param file - куда записываем
     * @throws IOException
     */
    public static void writingToFile(Path file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = bufferedReader.readLine();
        while(!s.equals("exit")){
            sb.append(s+"\n");
            s = bufferedReader.readLine();
        }
        byte[] strToBytes = sb.toString().getBytes();
        Files.write(file,strToBytes);
        bufferedReader.close();
    }

    /**
     * считаем среднее второй половины третье четверти
     * @param list - все числа файла
     */
    public static void countAvgThreeFour(List<String> list){
        List<Integer> listInts = new ArrayList<>();
        List<Float> listFloats = new ArrayList<>();
        List<Byte> listBytes = new ArrayList<>();
        list.subList(0, list.size()/2).clear();
        list.subList(list.size()/2, list.size()).clear();
        for(String s : list){
            if(!s.contains(".")) {
                if(!(Integer.parseInt(s)>128) && !(Integer.parseInt(s) < -127))
                    listBytes.add(Byte.parseByte(s));
                else listInts.add(Integer.parseInt(s));
            } else listFloats.add(Float.parseFloat(s));
        }
        double sum = 0;
        for(float a : listFloats){
            sum+=a;
        }
        for(int a : listInts){
            sum+=a;
        }
        for(float a : listBytes){
            sum+=a;
        }
        double average = sum/(double)(listBytes.size()+listFloats.size()+listInts.size());
        System.out.println("среднее 3/4: "+average);
    }

    /**
     * Считываем числа с фалйа и считаем их среднее значение, а также количество целых чисел
     * @param file - откуда считываем
     */
    public static void readFromFile(File file){
        List<Integer> listInts = new ArrayList<>();
        List<Float> listFloats = new ArrayList<>();
        List<Byte> listBytes = new ArrayList<>();
        BufferedReader reader = null;
        List<String> list = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;

            while ((text = reader.readLine()) != null) {
                for(String s : text.split("\\s")){
                    if(!s.contains(".")) {
                        if(!(Integer.parseInt(s)>128) && !(Integer.parseInt(s) < -127))
                            listBytes.add(Byte.parseByte(s));
                        else listInts.add(Integer.parseInt(s));
                    } else listFloats.add(Float.parseFloat(s));
                    list.add(s);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
            }
        }
        double sum = 0;
        for(float a : listFloats){
            sum+=a;
        }
        for(int a : listInts){
            sum+=a;
        }
        for(float a : listBytes){
            sum+=a;
        }
        System.out.println("integers: "+listInts);
        System.out.println("bytes: "+listBytes);
        System.out.println("floats: "+listFloats);
        double average = sum/(double)(listBytes.size()+listFloats.size()+listInts.size());
        System.out.println("среднее: "+average);
        System.out.println("количество чисел типа int: " + listInts.size());
        countAvgThreeFour(list);
    }
//43.12 4533 231 1.23 321.2 0.123

/*
43.12 4533 231 1.23 321.2 0.123
120 32 24 250 64 -127
exit
*/
    public static void main(String[] args) throws IOException {
        Path file = Paths.get("src/ru/netcracker/task_2/numbers.txt");
        writingToFile(file);
        File fileToRead = new File("src/ru/netcracker/task_2/numbers.txt");
        readFromFile(fileToRead);
    }
}
