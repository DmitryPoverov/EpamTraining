package by.epam.multithreading.dmDev26.lesson9Semaphore;

import java.util.concurrent.Semaphore;

public class BuyerThread implements Runnable {

    private final Semaphore semaphore;

    public BuyerThread(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
// we try to keep the monitor we wait until we will can do this
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " is serving in some cashBox");
            Thread.sleep(5L);
            System.out.println(Thread.currentThread().getName() + " is setting free some cashBox");
// we let off the monitor
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

