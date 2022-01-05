package by.epam.multithreading.dmDev25.lesson7Volatile;

public class VolatileDemo {

    private static volatile boolean flag;

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(() -> {
            while (!flag) {
                System.out.println("Flag still is false: " + System.currentTimeMillis());
            }
        });
        thread1.start();
        Thread.sleep(1L);

        Thread thread2 = new Thread(() -> {
            flag = true;
            System.out.println("Flag was set: " + System.currentTimeMillis());
        });
        thread2.start();
    }
}
