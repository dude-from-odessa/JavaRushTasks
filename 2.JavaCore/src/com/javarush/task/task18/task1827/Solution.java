package com.javarush.task.task18.task1827;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

/* 
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        String productName = args[1];
        String price = args[2];
        String quantity = args[3];

        String path;

        try (BufferedReader pathReader = new BufferedReader(new InputStreamReader(System.in));
             FileReader fileReader = new FileReader(path = pathReader.readLine());
             FileWriter fileWriter = new FileWriter(path, true);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            int id = 0;
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                int currentId = Integer.parseInt(line.substring(0, 8).trim());
                if (currentId >= id) {
                    id = currentId;
                }
            }

            String strId = String.valueOf(id + 1);

            StringBuilder stringBuilder = new StringBuilder(50);

            for (int i = 0; i < 50; i++) {
                stringBuilder.append(" ");
            }

            stringBuilder.replace(0, strId.length(), strId);

            if (productName.length() > 30) {
                stringBuilder.replace(8, 38, productName.substring(0, 30));
            } else {
                stringBuilder.replace(8, 8 + productName.length(), productName);
            }

            if (price.length() > 8) {
                stringBuilder.replace(38, 46, price.substring(0, 8));
            } else {
                stringBuilder.replace(38, 38 + price.length(), price);
            }

            if (quantity.length() > 4) {
                stringBuilder.replace(46, 50, quantity.substring(0, 4));
            } else {
                stringBuilder.replace(46, 46 + quantity.length(), quantity);
            }

            if (args[0].equals("-c")) {
                if(id==1) {
                    fileWriter.write("\n" + stringBuilder);
                } else {
                    fileWriter.write(stringBuilder.toString());
                }
            }

        }
    }
}
