package com.javarush.task.task19.task1923;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
             BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]))) {

            List<String> stringArrayList = new ArrayList<>();
            String str;
            while ((str = reader.readLine()) != null) {
                String[] array = str.split(" ");
                stringArrayList.addAll(Arrays.asList(array));
            }

            for (String string : stringArrayList) {
                if (string.matches(".*\\d.*")) {
                    writer.write(string + " ");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}