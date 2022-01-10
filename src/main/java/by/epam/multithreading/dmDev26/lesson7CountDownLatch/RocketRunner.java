package by.epam.multithreading.dmDev26.lesson7CountDownLatch;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RocketRunner {
    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(RocketDetail.values().length);
        ExecutorService threadPool = Executors.newFixedThreadPool(4);

        threadPool.submit(new RocketThread(countDownLatch));
        Arrays.stream(RocketDetail.values())
                .map(detail -> new RocketDetailThread(detail, countDownLatch))
                .forEach(threadPool::submit);

        threadPool.shutdown();
        try {
            threadPool.awaitTermination(30L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {

        }
    }
}
