package com.javarush.task.task18.task1817;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream(args[0])) {

            int spaces = 0;
            int characters = 0;
            while (fileInputStream.available() > 0) {
                int character = fileInputStream.read();
                if (character == 32) {
                    spaces++;
                }
                characters++;
            }
            double print = ((double) spaces / characters) * 100;

            System.out.println(Math.round(print * 100) / 100.0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
