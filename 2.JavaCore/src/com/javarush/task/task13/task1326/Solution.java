package com.javarush.task.task13.task1326;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        try (Scanner scanner = new Scanner(System.in);
             InputStream inputStream = new FileInputStream(scanner.nextLine());
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            List<Integer> list = new ArrayList<>();
            while (reader.ready()) {
                list.add(Integer.valueOf(reader.readLine()));
            }
            list.stream().filter(n -> n % 2 == 0).sorted((o1, o2) -> o1 - o2).forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
