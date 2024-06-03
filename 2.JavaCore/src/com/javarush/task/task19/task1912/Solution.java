package com.javarush.task.task19.task1912;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/* 
Ридер обертка 2
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream printStream = System.out;  // PrintStream extends -> FilterOutputStream extends -> OutputStream - public abstract class

        OutputStream outputStream = new ByteArrayOutputStream(); // ByteArrayOutputStream extends -> OutputStream

        PrintStream printStream1 = new PrintStream(outputStream);

        System.setOut(printStream1);

        testString.printSomething();

        String str = outputStream.toString().replaceAll("te","??");

        System.setOut(printStream);

        System.out.println(str);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
