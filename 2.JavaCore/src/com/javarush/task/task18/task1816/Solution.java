package com.javarush.task.task18.task1816;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream(args[0])) {

            int character;
            int count = 0;
            while ((character = fileInputStream.read()) > 0) {
                if ((character >= 65 && character <= 90) || (character >= 97 && character <= 122)) {
                    count++;
                }
            }
            System.out.println(count);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
