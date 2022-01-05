package by.epam.multithreading.dmDev25.lesson12Practice1;

import java.util.Queue;

public class ProducerThread implements Runnable{

    private final Queue<Integer> list;

    public ProducerThread(Queue<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (list) {
            while (true) {
                if (list.size() < 10) {
                    int random = RandomUtil.getRandom();
                    list.add(random);
                    System.out.println("Producer adds value: " + random + ". Size: " + list.size());
                } else {
                    System.out.println("Producer does nothing (size=10)");
                }
                // list.notifyAll();
                try {
                    // int randomWaitValue = RandomUtil.getRandom(2);
                    int randomWaitValue = 20;
                    System.out.println("Producer waits: " + randomWaitValue + "ms");
                    list.wait(randomWaitValue);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
