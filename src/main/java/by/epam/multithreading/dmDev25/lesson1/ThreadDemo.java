package by.epam.multithreading.dmDev25.lesson1;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {

//      Thread thread0 = new SimpleThread();
//      Thread thread1 = new SimpleThread();
//      Thread thread2 = new SimpleThread();
//      Thread thread3 = new SimpleThread();

        SimpleThread thread0 = new SimpleThread();
        SimpleThread thread1 = new SimpleThread();
        SimpleThread thread2 = new SimpleThread();
        SimpleThread thread3 = new SimpleThread();

//      thread0.run();  // Method run() calls start() from main()-thread and runs thread0 into the main()
                        // method start() runs individual thread, into another new thread
        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();

        thread0.join(); // join() induces main() to wait thread3 work ending. main() will wait till thread0 ends to work
        thread1.join(); // ...
        thread2.join(); // ...
        thread3.join(); // each thread will not wait each other, only main() will wait each thread with join()

        System.out.println("Hello from: " + Thread.currentThread().getName());
    }
}
