package by.epam.multithreading.dmDev25.lesson4and5AtomicSynchronized;

/**
 * 1. Создать класс Counter с одним полем:
 * private int count;
 *
 * Добавить методы:
 * - getCount() - для получения поля count
 * - increment() - для увеличения значения поля на единицу
 * - decrement() - для уменьшения значения поля на единицу
 */

public class Counter {

// in default all primitive types are initialize by zero
    private int count;
    private static String description;

    public static void init() {
        synchronized (Counter.class) {
            if (description == null) {
                description = "Test description";
            }
        }
    }

// it's necessary to pass Object whom monitor we have to grip
    public void increment() {
        synchronized (this) {
            count++;
        }
    }

    public synchronized void decrement() {
        count--;
    }

    public int getCount() {
        return count;
    }
}
