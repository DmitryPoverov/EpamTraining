package by.epam.multithreading.dmDev25.lesson2and3;

public class RunnableThread implements Runnable{

    @Override
    public void run() {
        System.out.println("Hello from: " + Thread.currentThread().getName());
    }
}
