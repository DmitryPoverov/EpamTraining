package by.epam.multithreading.dmDev25.lesson12Practice;

import java.util.LinkedList;
import java.util.Queue;

public class ConsumerProducerRunner {
    public static void main(String[] args) throws InterruptedException {

        Queue<Integer> queue = new LinkedList<>();

        Thread producerThread = new Thread(new ProducerThread(queue));
        Thread consumerThread = new Thread(new ConsumerThread(queue));

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();
    }
}
