package com.javarush.task.task18.task1821;

import java.io.FileInputStream;
import java.io.IOException;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) {

        int[] table = new int[127];
        int character;
        try (FileInputStream fileInputStream = new FileInputStream(args[0])) {
            while ((character = fileInputStream.read()) > -1) {
                if(character <= 127) {
                    table[character] += 1;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < table.length; i++) {
            if (table[i] != 0) {
                System.out.printf("%c %d%n", (char) i, table[i]);
            }
        }

    }
}
