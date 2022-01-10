package by.epam.multithreading.dmDev26.lesson9Semaphore;

import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CashBoxRunner {
    public static void main(String[] args) throws InterruptedException {

        Semaphore cashBoxes = new Semaphore(2);

        Stream<BuyerThread> stream = Stream.of(
                new BuyerThread(cashBoxes),
                new BuyerThread(cashBoxes),
                new BuyerThread(cashBoxes),
                new BuyerThread(cashBoxes),
                new BuyerThread(cashBoxes),
                new BuyerThread(cashBoxes),
                new BuyerThread(cashBoxes),
                new BuyerThread(cashBoxes));

        List<Thread> threads = stream
                .map(Thread::new)
                .peek(Thread::start)
                .collect(Collectors.toList());

        for (Thread thread : threads) {
            thread.join();
        }
    }
}
