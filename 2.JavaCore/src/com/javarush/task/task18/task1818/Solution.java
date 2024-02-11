package com.javarush.task.task18.task1818;

import java.io.*;
import java.util.stream.Stream;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) {

        try (BufferedReader path = new BufferedReader(new InputStreamReader(System.in));
             FileOutputStream file1 = new FileOutputStream(path.readLine(), true);
             FileInputStream file2 = new FileInputStream(path.readLine());
             FileInputStream file3 = new FileInputStream(path.readLine())) {

            while (file2.available() > 0) {
                file1.write(file2.read());
            }

            file1.write('\n');

            while (file3.available() > 0) {
                file1.write(file3.read());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
