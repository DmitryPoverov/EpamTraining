package by.epam.multithreading.dmDevPractice2;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class OneOrParallelThreadsDemo {
    public static void main(String[] args) {
        int[] values = new int[300_000_000];
        Random random = new Random();
        for (int i=0; i< values.length; i++) {
            values[i] = random.nextInt(300) + 1; // cause nextInt() get random from 0 to 299 (need from 1 to 300)
        }
/* Это примитивное решение без StreamAPI
        long startTime = System.currentTimeMillis();
        int result = findMaxParallel(values);
        long endTime = System.currentTimeMillis();
        System.out.println("Several streams measuring (max=" + result + ") " + (endTime-startTime) + "sec.");

        long startTime = System.currentTimeMillis();
        int result = findMax(values);
        long endTime = System.currentTimeMillis();
        System.out.println("One stream measuring (max=" + result + ") " + (endTime-startTime) + "sec.");*/

        trackTime(() -> findMax(values));

        trackTime(() -> findMaxParallel(values));

        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        trackTime(() -> {
            try {
                return findMaxParallel(values, threadPool);
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
            return Integer.MIN_VALUE;
        });
        threadPool.shutdownNow();
    }

    private static int findMaxParallel(int[] values, ExecutorService executorService) throws ExecutionException, InterruptedException {
        return executorService.submit(() -> IntStream.of(values)
                .parallel()
                .max()
                .orElse(Integer.MIN_VALUE)).get();
    }

    private static void trackTime(Supplier<Integer> task) {
        long startTime = System.currentTimeMillis();
        int result = task.get();
        System.out.println(result + (System.currentTimeMillis()-startTime) + " ms.");
    }

    private static int findMax(int[] values) {
        return IntStream.of(values)
                .max()
                .orElse(Integer.MIN_VALUE);
    }

    private static int findMaxParallel(int[] values) {
        return IntStream.of(values)
                .parallel()
                .max()
                .orElse(Integer.MIN_VALUE);
    }
}
