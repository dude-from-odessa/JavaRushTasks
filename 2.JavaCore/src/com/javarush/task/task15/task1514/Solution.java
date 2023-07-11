package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
    labels.put(10.2,"Mars");
    labels.put(11.3,"Snickers");
    labels.put(22.2,"ODESSA");
    labels.put(45.5,"MSI");
    labels.put(60.3,"Boom");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
