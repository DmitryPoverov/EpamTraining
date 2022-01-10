package by.epam.multithreading.dmDev26.lesson8CyclicBarrier;

import by.epam.multithreading.dmDev26.lesson7CountDownLatch.RocketDetail;

import java.util.Arrays;
import java.util.concurrent.*;

public class RocketRunner {
    public static void main(String[] args) {

        //CyclicBarrier cyclicBarrier = new CyclicBarrier(RocketDetail.values().length, ()-> System.out.println("Launch!!!"));

// Here length()+1 is for "Launch!!!" line in RocketThread
        CyclicBarrier cyclicBarrier = new CyclicBarrier(RocketDetail.values().length+1);
// This thread is for rocket. We give it cyclicBarrier.
        Thread thread = new Thread(new RocketThread(cyclicBarrier));
        ExecutorService threadPool = Executors.newCachedThreadPool();

// Here we are executing thread with rocket (preparing -> ... -> launching)
        threadPool.submit(thread);

        Arrays.stream(RocketDetail.values())
                .map(detail -> new RocketDetailConstructingThread(detail, cyclicBarrier))
                .forEach(threadPool::submit);
        threadPool.shutdown();
        try {
            threadPool.awaitTermination(30L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
