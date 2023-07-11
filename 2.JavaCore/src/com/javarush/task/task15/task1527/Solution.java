package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Stream;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        //напишите тут ваш код
        String[] strings = url.substring(url.indexOf('?') + 1).split("&");
        Map<String, String> map = new LinkedHashMap<>();

        for (String str : strings) {
            if (str.contains("=")) {
                String[] stringMap = str.split("=");
                map.put(stringMap[0], stringMap[1]);
            } else {
                map.put(str, null);
            }
        }
        for (String obj : map.keySet()){
            System.out.print(obj+" ");
        }
        System.out.println();
        for (String obj : map.keySet()){
            String str = map.get(obj);
            if("obj".equals(obj)) {
                try {
                    double value = Double.parseDouble(str);
                    alert(value);
                } catch (Exception e) {
                    alert(str);
                }
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
