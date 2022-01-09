package by.epam.multithreading.dmDev25.lesson12Practice;

import java.util.Queue;

public class ConsumerThread implements Runnable {

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
                    int random = RandomUtil.getRandom(); // this value we'll needed in sout and in wait()
                    System.out.println((random==0? " !!!!!!!!!!!!!" : "") + "Consume waits: " + random + "ms");
/* this line was needed to wake up threads when wait(0) and random works without +1
                    list.notifyAll();*/
                    list.wait(random);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* I commented out this code for writing a new version
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
    }*/
}
