package by.epam.multithreading.dmDev25.utils;

public final class DmDevUtils {

    private DmDevUtils() {
    }

    public static void getThreadState(Thread thread) {
        System.out.println(thread.getName() + " : " + thread.getState());
    }

    public static void getThreadStates(Thread thread1, Thread thread2) {
        System.out.println(thread1.getName() + " : " + thread2.getState());
        System.out.println(thread1.getName() + " : " + thread2.getState());
    }
}
