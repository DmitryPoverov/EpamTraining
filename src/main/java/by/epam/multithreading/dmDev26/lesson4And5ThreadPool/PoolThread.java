package by.epam.multithreading.dmDev26.lesson4And5ThreadPool;

import java.util.Optional;
import java.util.Queue;

// This is an example of the thread pool, which we wrote by ourselves.
public class PoolThread extends Thread {

    private final Queue<Runnable> tasks;

    public PoolThread(Queue<Runnable> tasks) {
        this.tasks = tasks;
    }

    @Override
    public void run() {
        while (true) {
            Optional<Runnable> task = Optional.empty();
            synchronized (tasks) {
                if (!tasks.isEmpty()) {
                    task = Optional.of(tasks.remove());
                }
            }
            task.ifPresent(Runnable::run);

        }
    }
}
