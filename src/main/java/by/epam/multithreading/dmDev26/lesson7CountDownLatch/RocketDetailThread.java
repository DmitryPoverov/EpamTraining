package by.epam.multithreading.dmDev26.lesson7CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class RocketDetailThread implements Runnable {

    private final RocketDetail rocketDetail;
    private final CountDownLatch countDownLatch;

    public RocketDetailThread(RocketDetail rocketDetail, CountDownLatch countDownLatch) {
        this.rocketDetail = rocketDetail;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("Now is preparing a detail: " + rocketDetail);
        try {
            Thread.sleep(1000L);
            System.out.println("The detail is ready: " + rocketDetail);
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
