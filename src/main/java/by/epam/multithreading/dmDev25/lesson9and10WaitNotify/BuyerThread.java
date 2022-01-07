package by.epam.multithreading.dmDev25.lesson9and10WaitNotify;

import java.util.Queue;

public class BuyerThread implements Runnable {

    private final Queue<CashBox> cashBoxes;

    public BuyerThread(Queue<CashBox> cashBoxes) {
        this.cashBoxes = cashBoxes;
    }

    @Override
    public void run() {
        try {
            synchronized (cashBoxes) {
                while (true) {
                    if (!cashBoxes.isEmpty()) {
                        CashBox cashBox = cashBoxes.remove();
                        System.out.println(Thread.currentThread().getName() + " is serving in " + cashBox);

                        cashBoxes.wait(100L); // to use wait() we have to capture the object monitor

                        System.out.println(Thread.currentThread().getName() + " is setting free " + cashBox);
                        cashBoxes.add(cashBox);
                        cashBoxes.notifyAll(); // we'll notify all waiting threads (notify() - only one random thread)
                        break;
                    } else {
                        System.out.println(Thread.currentThread().getName() + " is waiting for free cash box");
                        cashBoxes.wait();// == cashBoxes.wait(0L)
                        // * we'll wait until from cashBoxes will call notify() or notifyAll()
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
/* Version without synchronized(){} and wait() and notifyAll()
    @Override
    public void run() {
        try {
            while (true) {
                if (!cashBoxes.isEmpty()) {
                    CashBox cashBox = cashBoxes.remove();
                    System.out.println(Thread.currentThread().getName() + " is serving in " + cashBox);

                    Thread.sleep(1L);

                    System.out.println(Thread.currentThread().getName() + " is setting free " + cashBox);
                    cashBoxes.add(cashBox);
                    break;
                } else {
                    System.out.println(Thread.currentThread().getName() + " is waiting for free cash box");
                    Thread.sleep(1L);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/
}

