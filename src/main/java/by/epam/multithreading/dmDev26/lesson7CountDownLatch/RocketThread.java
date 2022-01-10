package by.epam.multithreading.dmDev26.lesson7CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class RocketThread implements Runnable {

    private final CountDownLatch countDownLatch;

    public RocketThread(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("Rocket is preparing to launch...");
        try {
            countDownLatch.await();
            System.out.println("LAUNCHING!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
