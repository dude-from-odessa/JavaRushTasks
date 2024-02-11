package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             FileInputStream fileInputStream = new FileInputStream(scanner.nextLine());
             FileOutputStream fileOutputStream = new FileOutputStream(scanner.nextLine())) {
            byte[] buffer = new byte[fileInputStream.available()];

            fileInputStream.read(buffer);

            for (int i = buffer.length - 1; i >= 0; i--) {
                fileOutputStream.write(buffer[i]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
