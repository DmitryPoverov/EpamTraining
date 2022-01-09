package by.epam.multithreading.dmDev26.lesson2Atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicRunner {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println("Atomic = " + atomicInteger.get());
        System.out.println("Atomic + 1 = " + atomicInteger.incrementAndGet());
        System.out.println("Atomic + 10 = " + atomicInteger.addAndGet(10));
    }
}
