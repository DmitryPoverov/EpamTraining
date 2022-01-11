package by.epam.multithreading.dmDev26.lesson10Practice.secondTrying;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 1. Написать программу, бесконечно считывающую пользовательские числа из консоли.
 * Эти числа представляют собой количество секунд.
 * При каждом вводе числа, должна создаваться задача, которая засыпает на введённое число секунд
 * и затем выводит "Я спал N секунд".
 * Однако нужно сделать так, чтобы все задачи выполнялись в одном и том же потоке в порядке ввода.
 * Т.е. в программе есть 2 потока: главный и поток для выполнения всех задач по очереди.
 * При вводе отрицательного числа программа должна завершать свою работу.
 * Второе решение - несколько потоков в пуле. Посчитать кол-во обработанных задач каждым потоком
 */

public class Task1 {
    public static void main(String[] args) throws InterruptedException {

/* This line is for single thread
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
This line is for several threads */
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>(); // each variable saves its own value which we have set

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int seconds = scanner.nextInt();
            if (seconds < 0) {
                break;
            }
            threadPool.submit(() -> {
                Integer counter = threadLocal.get();
                threadLocal.set(counter == null ? 1 : ++counter);
                TimeUnit.SECONDS.sleep(seconds);
                System.out.printf("Thread %s slept %d second(s)\n", Thread.currentThread().getName(), seconds);
                System.out.printf("The %s execute %d task(s)\n", Thread.currentThread().getName(), threadLocal.get());
                return seconds; //cause callable has to return something
            });
        }
        threadPool.shutdown();
        threadPool.awaitTermination(1L, TimeUnit.MINUTES);
    }
}
