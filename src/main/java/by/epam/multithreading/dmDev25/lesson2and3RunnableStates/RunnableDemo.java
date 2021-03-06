package by.epam.multithreading.dmDev25.lesson2and3RunnableStates;

import by.epam.multithreading.dmDev25.lesson2and3RunnableStates.utils.DmDevUtils;

public class RunnableDemo {
    public static void main(String[] args) throws InterruptedException {

        Thread runnableThread = new Thread(new RunnableThread());
        Thread lambdaThread = new Thread(() -> System.out.println("Hello from lambda: " + Thread.currentThread().getName()));

        DmDevUtils.getThreadStates(runnableThread, lambdaThread);

        runnableThread.start();
        lambdaThread.start();

        DmDevUtils.getThreadState(runnableThread);
        DmDevUtils.getThreadState(lambdaThread);

        runnableThread.join();
        lambdaThread.join();

        DmDevUtils.getThreadStates(runnableThread, lambdaThread);

        System.out.println("Hello from: " + Thread.currentThread().getName());
    }
}