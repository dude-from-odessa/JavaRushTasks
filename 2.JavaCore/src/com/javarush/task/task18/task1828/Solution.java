package com.javarush.task.task18.task1828;

import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы 2
*/

public class Solution {
    public static void main(String[] args) {

        String path;

        try (BufferedReader pathReader = new BufferedReader(new InputStreamReader(System.in));
             FileReader fileReader = new FileReader(path = pathReader.readLine());
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            int id = 0;
            String line;

            if ("-c".equals(args[0])) {

                FileWriter fileWriter = new FileWriter(path, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                while ((line = bufferedReader.readLine()) != null) {
                    int currentId = Integer.parseInt(line.substring(0, 8).trim());
                    if (currentId >= id) {
                        id = currentId;
                    }
                }

                String strId = String.valueOf(id + 1);

                StringBuilder stringBuilder = buildLine(strId, args[1], args[2], args[3]);

                if (id != 1) {
                    bufferedWriter.write("\n" + stringBuilder);
                } else {
                    bufferedWriter.write(stringBuilder.toString());
                }

                bufferedWriter.close();

            } else if("-u".equals(args[0])){

                ArrayList<String> arrayList = new ArrayList<>();
                while((line = bufferedReader.readLine()) != null){
                    if(!line.substring(0,8).trim().equals(args[1])){
                        arrayList.add(line);
                    } else {
                        arrayList.add(buildLine(args[1],args[2],args[3],args[4]).toString());
                    }
                }

                FileWriter fileWriter = new FileWriter(path);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                for (String str : arrayList){
                    bufferedWriter.write(str);
                    bufferedWriter.newLine();
                }

                bufferedWriter.close();

            }

            else if ("-d".equals(args[0])){

                ArrayList<String> arrayList = new ArrayList<>();
                while((line = bufferedReader.readLine()) != null){
                    if(!line.substring(0,8).trim().equals(args[1])){
                        arrayList.add(line);
                    }
                }

                FileWriter fileWriter = new FileWriter(path);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                for (String str : arrayList){
                    bufferedWriter.write(str);
                    bufferedWriter.newLine();
                }

                bufferedWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static StringBuilder buildLine(String strId, String productName, String price, String quantity) {

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

        return stringBuilder;
    }
}
