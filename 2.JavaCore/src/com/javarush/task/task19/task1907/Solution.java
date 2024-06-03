package com.javarush.task.task19.task1907;

import java.io.*;
import java.util.Arrays;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) {

        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(bufferedReader.readLine())){
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (fileReader.ready()){
                byteArrayOutputStream.write(fileReader.read());
            }
            String[] words = byteArrayOutputStream.toString().split("[,.!?\\s]+");
            long count = Arrays.stream(words).filter(world -> world.equals("world")).count();
            System.out.println(count);
            byteArrayOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}