package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]))) {
            String values;
            while ((values = bufferedReader.readLine()) != null) {
                String[] arrayValues = values.split(" ");

                Calendar calendar = new GregorianCalendar(Integer.parseInt(arrayValues[arrayValues.length - 1]),
                        Integer.parseInt(arrayValues[arrayValues.length - 2])-1,
                        Integer.parseInt(arrayValues[arrayValues.length - 3]));
                Date date = calendar.getTime();

                StringBuilder name = new StringBuilder();
                for (int i = 0; i < arrayValues.length - 3; i++) {
                    name.append(arrayValues[i] + " ");
                }

                PEOPLE.add(new Person(name.toString().trim(), date));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}