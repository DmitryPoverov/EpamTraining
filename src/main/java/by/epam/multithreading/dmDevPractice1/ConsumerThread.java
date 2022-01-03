package by.epam.multithreading.dmDevPractice1;

import java.util.Queue;

public class ConsumerThread implements Runnable{

    private final Queue<Integer> list;

    public ConsumerThread(Queue<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (list) {
            while (true) {
                if (!list.isEmpty()) {
                    Integer removedValue = list.remove();
                    System.out.println("Consumer get value " + removedValue + ". Size: " + list.size());
                } else {
                    System.out.println("Consumer is waiting. List is empty");
                }
                try {
                    // int random = RandomUtil.getRandom();
                    int random = 80;
                    System.out.println("Consume waits: " + random + "ms");
                    // list.notifyAll();
                    list.wait(random);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
