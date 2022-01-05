package by.epam.multithreading.dmDev25.lesson1Thread;

public class SimpleThread extends Thread{

    @Override
    public void run() {
        //System.out.println("Hello from thread: " + Thread.currentThread().getName());
        System.out.println("Hello from: " + getName());

    }
}
