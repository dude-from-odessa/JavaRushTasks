package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader bufferedReader = new BufferedReader(new FileReader(consoleReader.readLine()))) {
            String str;

            while ((str = bufferedReader.readLine()) != null) {
                ArrayList<String> array = new ArrayList<>(Arrays.asList(str.split(" ")));
                int counter = 0;
                for (String word : words) {
                    for (String s : array) {
                        if (word.equals(s)) {
                            counter++;
                            if (counter > 2) {
                                break;
                            }
                        }
                    }
                    if (counter > 2) {
                        break;
                    }
                }
                if (counter == 2) {
                    System.out.println(str);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
