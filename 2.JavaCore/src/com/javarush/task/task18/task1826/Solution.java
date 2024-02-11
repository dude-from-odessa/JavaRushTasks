package com.javarush.task.task18.task1826;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) {
        try (FileInputStream inputStream = new FileInputStream(args[1]);
             FileOutputStream outputStream = new FileOutputStream(args[2])) {
            final int KEY = 42;
            switch (args[0]) {
                case "-e":
            while(inputStream.available()>0){
                int read = inputStream.read();
                outputStream.write(read ^ KEY);
            }
                case "-d":
                    while(inputStream.available()>0){
                        int read = inputStream.read();
                        outputStream.write(read ^ KEY);
                    }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
