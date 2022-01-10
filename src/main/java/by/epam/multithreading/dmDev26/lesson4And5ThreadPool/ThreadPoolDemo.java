package by.epam.multithreading.dmDev26.lesson4And5ThreadPool;

import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
/* From more popular to less
        Executors.newFixedThreadPool(5);
        Executors.newSingleThreadExecutor();
        Executors.newCachedThreadPool();
        Executors.newScheduledThreadPool(3);
        Executors.newWorkStealingPool();
*/
/* schedule() is needed shutdown() and awaitTermination()*/
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(4);
        threadPool.schedule(() -> System.out.println("It's OK from sout"), 2L, TimeUnit.SECONDS);
        threadPool.shutdown();
        threadPool.awaitTermination(1L, TimeUnit.HOURS);

/* scheduleAtFixedRate() is no needed shutdown() and awaitTermination()
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(4);
        threadPool.scheduleAtFixedRate(() -> System.out.println("It's OK from sout"), 1L, 2L, TimeUnit.SECONDS);
*/
    }

    private static void test() throws InterruptedException, ExecutionException {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        Future<Integer> future  = threadPool.submit(() -> {
            TimeUnit.SECONDS.sleep(1L);
            System.out.println("It's callable: " + Thread.currentThread().getName());
            return 1;
        });

        System.out.println("future.get(): " + future.get());
        threadPool.shutdown();
        threadPool.awaitTermination(5L, TimeUnit.SECONDS);
        System.out.println("main() ends");
    }
}
