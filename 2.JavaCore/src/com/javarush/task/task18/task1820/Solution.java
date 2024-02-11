package com.javarush.task.task18.task1820;

import java.io.*;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fileInputStream = new FileInputStream(console.readLine());
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(console.readLine(), true))) {

            StringBuilder stringBuilder = new StringBuilder();

            int byteData;
            while ((byteData = fileInputStream.read()) != -1) {
                stringBuilder.append((char) byteData);
            }

            String[] numbers = stringBuilder.toString().split(" ");

            for (String numStr : numbers) {
                double number = Double.parseDouble(numStr);
                bufferedWriter.write(Math.round(number) + " ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
