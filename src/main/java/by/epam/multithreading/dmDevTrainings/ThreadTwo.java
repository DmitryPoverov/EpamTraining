package by.epam.multithreading.dmDevTrainings;

public class ThreadTwo implements Runnable {

    public void run() {
        try {
            for (int i = 0; i < 3; i++) {
                System.out.println("Thread 2 counts: " + CounterHolder.counter++);
                Thread.sleep(100);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
