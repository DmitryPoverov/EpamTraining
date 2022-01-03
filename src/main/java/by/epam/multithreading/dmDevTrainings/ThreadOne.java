package by.epam.multithreading.dmDevTrainings;

public class ThreadOne extends Thread {

    public void run() {
        try {
            for (int i = 0; i < 3; i++) {
                System.out.println("Thread 1 counts: " + CounterHolder.counter++);
                Thread.sleep(100);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
