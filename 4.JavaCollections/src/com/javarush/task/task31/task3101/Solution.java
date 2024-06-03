package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Map;
import java.util.TreeMap;

import static com.javarush.task.task31.task3101.Solution.iteratePath;

/* 
Проход по дереву файлов
*/

/*
Проход по дереву файлов
1. На вход метода main() подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя (полный путь) существующего файла, который будет содержать результат.
2. Переименовать resultFileAbsolutePath в allFilesContent.txt (используй метод FileUtils.renameFile(), и, если понадобится, FileUtils.isExist()).
3. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
Если у файла длина в байтах НЕ больше 50, то записать его содержимое в allFilesContent.txt.
После каждого тела файла записать "\n".
Все файлы имеют расширение txt.
В качестве разделителя пути используй "/".
Для создания файлов используй конструктор File(String pathname).


Requirements:
1. Файл, который приходит вторым параметром в main, должен быть переименован в allFilesContent.txt.
2. Нужно создать поток для записи в переименованный файл.
3. Содержимое всех файлов, размер которых не превышает 50 байт, должно быть записано в файл allFilesContent.txt.
4. Поток для записи в файл нужно закрыть.
5. Не используй статические переменные.
 */

public class Solution {
    public static void main(String[] args) {

        File path = new File(args[0]);  // путь к директории
        File source = new File(args[1]);
        File resultFile = new File(source.getParent() + "/allFilesContent.txt"); // (полный путь) существующего файла, который будет содержать результат

        // Переименовать resultFileAbsolutePath в allFilesContent.txt (используй метод FileUtils.renameFile(), и, если понадобится, FileUtils.isExist()).
        FileUtils.renameFile(source, resultFile);

        ArrayList<File> filesToSave = new ArrayList<>();
        iteratePath(path, filesToSave);


        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(resultFile))) {

            for (File file : filesToSave) {

                try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

                    ArrayList<String> data = new ArrayList<>();

                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        data.add(line);
                    }
                    for (String str : data) {
                        bufferedWriter.write(str);
                    }
                    bufferedWriter.write("\n");

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
    //Если у файла длина в байтах НЕ больше 50, то записать его содержимое в allFilesContent.txt.
    //После каждого тела файла записать "\n".
    //Все файлы имеют расширение txt.
    //В качестве разделителя пути используй "/".
    //Для создания файлов используй конструктор File(String pathname).


    public static void iteratePath(File source, ArrayList<File> filesToSave) {
        if (FileUtils.isExist(source) && source.isDirectory()) {
            for (File file : source.listFiles()) {
                iteratePath(file, filesToSave);
            }
        } else {
            /*
            Содержимое всех файлов, размер которых не превышает 50 байт, должно быть записано в файл allFilesContent.txt.
             */
            if (FileUtils.isExist(source) && source.length() <= 50) {
                filesToSave.add(source);
            }
        }
    }
}
