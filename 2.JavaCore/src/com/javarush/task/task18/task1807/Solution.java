package com.javarush.task.task18.task1807;

import java.io.*;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader filePath = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fileInputStream = new FileInputStream(filePath.readLine())) {
            int count = 0;
            while (fileInputStream.available()>0) {
                if (((char) fileInputStream.read()) == ',') {
                    count++;
                }
            }
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
