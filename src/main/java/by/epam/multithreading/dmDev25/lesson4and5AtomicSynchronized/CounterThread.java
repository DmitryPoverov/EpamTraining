package by.epam.multithreading.dmDev25.lesson4and5AtomicSynchronized;

/**
 * 2. Создать класс CounterThread c одним полем и конструктором для инициализации:
 * private Counter counter1;
 *
 * В методе run этого класса в цикле 100 раз вызвать counter.increment()
 */

public class CounterThread extends Thread{

    private final Counter counter;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i=0; i<100_000; i++) {
            counter.increment();
        }
    }
}
