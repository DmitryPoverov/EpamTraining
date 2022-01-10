package by.epam.multithreading.dmDev26.lesson8CyclicBarrier;

import by.epam.multithreading.dmDev26.lesson7CountDownLatch.RocketDetail;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class RocketDetailConstructingThread implements Runnable {

    private final RocketDetail rocketDetail;
    private final CyclicBarrier cyclicBarrier;

    public RocketDetailConstructingThread(RocketDetail rocketDetail, CyclicBarrier cyclicBarrier) {
        this.rocketDetail = rocketDetail;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println("Now is preparing a detail: " + rocketDetail);
        try {
            Thread.sleep(1000L);
            System.out.println("The detail is ready and waiting: " + rocketDetail);
            cyclicBarrier.await();
            System.out.println("The detail was used: " + rocketDetail);
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
