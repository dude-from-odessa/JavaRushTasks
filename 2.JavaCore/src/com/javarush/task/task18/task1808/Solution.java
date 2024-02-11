package com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) {

        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fileInputStream = new FileInputStream(consoleReader.readLine());
             FileOutputStream fileOutputStream1 = new FileOutputStream(consoleReader.readLine());
             FileOutputStream fileOutputStream2 = new FileOutputStream(consoleReader.readLine())) {
            int size = fileInputStream.available() / 2;

            while (size != 0) {
                fileOutputStream1.write(fileInputStream.read());
                size--;
            }
            while (fileInputStream.available() > 0) {
                fileOutputStream2.write(fileInputStream.read());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
