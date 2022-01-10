package by.epam.multithreading.dmDev26.lesson8CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class RocketThread implements Runnable {

    private final CyclicBarrier cyclicBarrier;

    public RocketThread(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
// this code will work when we will start this thread
        System.out.println("Rocket is preparing...");
        try {
// Here we will wait until cyclicBarrier will count 6
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
// this code will work only when cyclic barrier will count 6 (5 details + 1)
        System.out.println("LAUNCHING!!!");
    }
}
