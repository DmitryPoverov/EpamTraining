package by.epam.multithreading.dmDev26.lesson6ThreadSafeCollections;

import by.epam.multithreading.dmDev25.lesson9and10WaitNotify.CashBox;

import java.util.concurrent.BlockingQueue;

public class BuyerThread implements Runnable {

    private final BlockingQueue<CashBox> cashBoxes;

    public BuyerThread(BlockingQueue<CashBox> cashBoxes) {
        this.cashBoxes = cashBoxes;
    }

    @Override
    public void run() {
        try {
            CashBox cashBox = cashBoxes.take();
            System.out.println(Thread.currentThread().getName() + " is serving in " + cashBox);
            Thread.sleep(5L);
            System.out.println(Thread.currentThread().getName() + " is setting free " + cashBox);
            cashBoxes.add(cashBox);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

