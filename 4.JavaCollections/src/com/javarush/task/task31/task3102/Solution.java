package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Находим все файлы
*/

public class Solution {

    public static List<String> getFileTree(String root) throws IOException {

        List<String> fileTree = new ArrayList<>();

        Stack<File> stack = new Stack<>();

        stack.push(new File(root));

        while (!stack.isEmpty()) {

            File source = stack.pop();

            if (source.isDirectory()) {
                for (File file : source.listFiles()) {
                    stack.push(file);
                }
            } else {
                fileTree.add(source.getAbsolutePath());
            }
        }

        return fileTree;
    }

    public static void main(String[] args) {

    }
}
