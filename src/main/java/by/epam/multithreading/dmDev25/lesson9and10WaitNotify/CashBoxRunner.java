package by.epam.multithreading.dmDev25.lesson9and10WaitNotify;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class CashBoxRunner {
    public static void main(String[] args) throws InterruptedException {

// two cash boxes are for list
        CashBox cashBox1 = new CashBox();
        CashBox cashBox2 = new CashBox();

// We created List based on two cashBoxes
        List<CashBox> cashBoxesList = List.of(cashBox1, cashBox2);

// We created Queue based on the List<CashBox>. This is dividing resource.
        Queue<CashBox> cashBoxes = new ArrayDeque<>(cashBoxesList);

        Thread thread1 = new Thread(new BuyerThread(cashBoxes));
        Thread thread2 = new Thread(new BuyerThread(cashBoxes));
        Thread thread3 = new Thread(new BuyerThread(cashBoxes));
        Thread thread4 = new Thread(new BuyerThread(cashBoxes));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();

/*  First variant with streams on java15
        List<Thread> threadList = List.of(new BuyerThread(cashBoxes),
                        new BuyerThread(cashBoxes),
                        new BuyerThread(cashBoxes),
                        new BuyerThread(cashBoxes))
                .stream()
                .map(Thread::new)
                .peek(Thread::start)
                .collect(Collectors.toList());
        for (Thread thread : threadList) {
            thread.join();
        }*/

/* Second variant with streams on java15
        List<Thread> threads = Stream.of(
                        new BuyerThread(cashBoxes),
                        new BuyerThread(cashBoxes),
                        new BuyerThread(cashBoxes),
                        new BuyerThread(cashBoxes),
                        new BuyerThread(cashBoxes),
                        new BuyerThread(cashBoxes),
                        new BuyerThread(cashBoxes),
                        new BuyerThread(cashBoxes))
                .map(Thread::new)
                .peek(Thread::start)
                .collect(Collectors.toList());
        for (Thread thread : threads) {
            thread.join();
        }*/
    }
}
