package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.*;

/* 
Загрузчик файлов
*/

/*
Загрузчик файлов
Реализуй метод downloadFile(String urlString, Path downloadDirectory), на вход которого подается ссылка для скачивания файла и папка, куда нужно закачать файл.
Все ссылки имеют вид:
https://yastatic.net/morda-logo/i/citylogos/yandex19-logo-ru.png
http://toogle.com/files/rules.txt
https://pacemook.com/photos/image1.jpg

Метод должен создать объект URL и загрузить содержимое файла на локальный диск.
Выкачивай сначала во временную директорию, чтобы в случае неуспешной загрузки в твоей директории не оставались недокачанные файлы.
Затем перемести файл в пользовательскую директорию. Имя для файла возьми из ссылки.
Используй только классы и методы из пакета java.nio.


Requirements:
1. Метод downloadFile должен создавать объект URL для переданной ссылки.
2. Метод downloadFile должен создать временный файл с помощью метода Files.createTempFile.
3. Метод downloadFile должен скачать файл по ссылке во временный файл, используя метод Files.copy.
4. Метод downloadFile должен переместить файл из временной директории в пользовательскую, используя метод Files.move.
5. Имя сохраненного файла должно быть таким же, как в URL-ссылке.
 */

public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        Path result = null;
        URL url = new URL(urlString);
        String name = urlString.substring(urlString.lastIndexOf("/") + 1);
        try (InputStream in = url.openConnection().getInputStream();) {
            Path temp = Files.createTempFile("myTempFile", ".temp");
            Files.copy(in, temp);
            result = Files.move(temp, downloadDirectory.resolveSibling(name));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
        // implement this method
    }

    // (+) Метод downloadFile должен создавать объект URL для переданной ссылки.
    // (-) Метод downloadFile должен создать временный файл с помощью метода Files.createTempFile.
    // (-) Метод downloadFile должен скачать файл по ссылке во временный файл, используя метод Files.copy
    // (-) Метод downloadFile должен переместить файл из временной директории в пользовательскую, используя метод Files.move.
    // (-) Имя сохраненного файла должно быть таким же, как в URL-ссылке.
    // Исключение системы безопасности JavaRush. Вы выполняете потенциально опасную или запрещенную операцию
}
