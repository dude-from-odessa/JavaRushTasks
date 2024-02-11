package com.javarush.task.task18.task1822;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader(new BufferedReader(new InputStreamReader(System.in)).readLine()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.substring(0, line.indexOf(' ')).equals(args[0])) {
                    System.out.println(line);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
