package com.javarush.task.task14.task1404;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import static com.javarush.task.task14.task1404.Solution.CatFactory.getCatByKey;

/* 
Коты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        while (true){
            String name = scanner.nextLine();
            if("".equals(name)){
                break;
            }
            Cat cat = getCatByKey(name);
            System.out.println(cat.toString());
        }
    }

    static class CatFactory {
        static Cat getCatByKey(String key) {
            Cat cat;
            switch (key) {
                case "vaska":
                    cat = new MaleCat("Василий");
                    break;
                case "murka":
                    cat = new FemaleCat("Мурочка");
                    break;
                case "kiska":
                    cat = new FemaleCat("Кисюлька");
                    break;
                default:
                    cat = new Cat(key);
                    break;
            }
            return cat;
        }
    }

    static class Cat {
        private String name;

        protected Cat(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public String toString() {
            return "Я уличный кот " + getName();
        }
    }

    static class MaleCat extends Cat {
        MaleCat(String name) {
            super(name);
        }

        public String toString() {
            return "Я - солидный кошак по имени " + getName();
        }
    }

    static class FemaleCat extends Cat {
        FemaleCat(String name) {
            super(name);
        }

        public String toString() {
            return "Я - милая кошечка по имени " + getName();
        }
    }
}
