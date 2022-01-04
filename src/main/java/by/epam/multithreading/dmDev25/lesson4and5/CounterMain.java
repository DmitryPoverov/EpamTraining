package by.epam.multithreading.dmDev25.lesson4and5;

/**
 * 3. В методе main создать 4 потока типа CounterThread, передав один и тот же объект Counter и запустить
 * их, дождаться выполнения и вывести на консоль в текущее значение нашего счетчика: counter.getCount()
 */

public class CounterMain {
    public static void main(String[] args) {

        Counter counter = new Counter();

        CounterThread counterThread0 = new CounterThread(counter);
        CounterThread counterThread1 = new CounterThread(counter);
        CounterThread counterThread2 = new CounterThread(counter);

        counterThread0.start();
        counterThread1.start();
        counterThread2.start();

        try {
            counterThread0.join();
            counterThread1.join();
            counterThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(counter.getCount());
    }
}
