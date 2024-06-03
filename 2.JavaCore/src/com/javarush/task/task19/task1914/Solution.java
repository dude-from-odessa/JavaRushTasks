package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream printStream = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        PrintStream printStream1 = new PrintStream(byteArrayOutputStream);

        System.setOut(printStream1);

        testString.printSomething();

        System.setOut(printStream);

        String[] strings = byteArrayOutputStream.toString().split(" ");

        int result = 0;

        switch (strings[1]) {
            case "+":
                result = Integer.parseInt(strings[0]) + Integer.parseInt(strings[2]);
                break;
            case "-":
                result = Integer.parseInt(strings[0]) - Integer.parseInt(strings[2]);
                break;
            case "*":
                result = Integer.parseInt(strings[0]) * Integer.parseInt(strings[2]);
                break;
        }

        System.out.println(strings[0] + " " + strings[1] + " " + strings[2] + " " + strings[3] + " " + result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}
