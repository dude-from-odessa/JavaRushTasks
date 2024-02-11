package com.javarush.task.task18.task1810;

import java.io.*;
import java.util.Scanner;

/* 
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws DownloadException {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            try (FileInputStream fileInputStream = new FileInputStream(scanner.nextLine())){
                if (fileInputStream.available() < 1000) {
                    scanner.close();
                    fileInputStream.close();
                    throw new DownloadException();
                }
            } catch (IOException e){
                scanner.close();
                e.printStackTrace();
            }
        }
    }

    public static class DownloadException extends Exception {

    }
}
