package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* 
Алгоритмы-числа
*/

public class Solution {

    public static long[] getNumbers(long N) {
        List<Long> resultList = new ArrayList<>();
        int processors = Runtime.getRuntime().availableProcessors(); // количество доступных процессоров
        ExecutorService executor = Executors.newFixedThreadPool(processors); // создаем пул потоков

        List<Future<List<Long>>> futures = new ArrayList<>();
        for (int i = 0; i < processors; i++) {
            final long start = (N / processors) * i + 1;
            final long end = (N / processors) * (i + 1);
            Callable<List<Long>> task = () -> {
                List<Long> localResult = new ArrayList<>();
                for (long j = start; j < end; j++) {
                    if (isArmstrongNumber(j))
                        localResult.add(j);
                }
                return localResult;
            };
            futures.add(executor.submit(task));
        }

        for (Future<List<Long>> future : futures) {
            try {
                resultList.addAll(future.get());
            } catch (Exception e) {
                // обработка ошибок, если есть
            }
        }

        executor.shutdown(); // закрываем пул потоков

        long[] resultArray = new long[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultArray[i] = resultList.get(i);
        }
        return resultArray;
    }

    public static boolean isArmstrongNumber(long number) {
        long sum = 0;
        long temp = number;
        int digits = String.valueOf(number).length();
        while (temp != 0) {
            long digit = temp % 10;
            sum += power(digit, digits);
            if (sum > number)
                return false;
            temp /= 10;
        }
        return sum == number;
    }

    public static long power(long base, int exponent) {
        long result = 1;
        while (exponent-- > 0) {
            result *= base;
        }
        return result;
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }
}
