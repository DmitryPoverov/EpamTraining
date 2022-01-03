package by.epam.multithreading.dmDevTrainings;

public class ThreadThree extends Thread {

    public void run() {
        try {
            for (int i = 0; i < 3; i++) {
                System.out.println("Thread 3 counts: " + CounterHolder.counter++);
                Thread.sleep(100);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

