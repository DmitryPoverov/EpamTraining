package by.epam.multithreading.dmDev25.lesson12Practice;

import java.util.Queue;

public class ProducerThread implements Runnable {

    // this is the list numbers which will produce producerThread
    private final Queue<Integer> list;

    public ProducerThread(Queue<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (list) {
            while (true) {
                if (list.size() < 10) {
                    int random = RandomUtil.getRandom(); // this value is for sout and for wait()
                    list.add(random); // at first we add element
                    System.out.println("Producer adds value: " + random + ". Size: " + list.size()); //then we use size()
                } else {
                    System.out.println("Producer does nothing (size=10)");
                }
                try {
                    int randomWaitValue = RandomUtil.getRandom(); // this value is for sout and for wait()
                    System.out.println("Producer waits: " + randomWaitValue + "ms");
/* This code was needed for work ability checking and now I commented out it
                    System.out.println((randomWaitValue==0? " !!!" : "") + "Producer waits: " + randomWaitValue + "ms");
                    list.notifyAll(); // this notifyAll() was needed to wake up threads when wait(0) (random without +1)*/
                    list.wait(randomWaitValue);
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
    }*/
}
