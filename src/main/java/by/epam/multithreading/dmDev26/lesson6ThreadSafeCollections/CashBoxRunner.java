package by.epam.multithreading.dmDev26.lesson6ThreadSafeCollections;

import by.epam.multithreading.dmDev25.lesson9and10WaitNotify.CashBox;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CashBoxRunner {
    public static void main(String[] args) throws InterruptedException {

        List<CashBox> list = List.of(new CashBox(), new CashBox());
        BlockingQueue<CashBox> cashBoxes = new ArrayBlockingQueue<>(2, true, list);

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
        }
    }
}
