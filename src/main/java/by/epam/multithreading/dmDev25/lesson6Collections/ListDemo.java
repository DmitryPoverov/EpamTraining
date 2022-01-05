package by.epam.multithreading.dmDev25.lesson6Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) throws InterruptedException {

// This operation is really power-hungry
        List<Integer> integers = Collections.synchronizedList(new ArrayList<>());

        ListThread listThread0 = new ListThread(integers);
        ListThread listThread1 = new ListThread(integers);
        ListThread listThread2 = new ListThread(integers);
        ListThread listThread3 = new ListThread(integers);
        ListThread listThread4 = new ListThread(integers);
        ListThread listThread5 = new ListThread(integers);
        ListThread listThread6 = new ListThread(integers);
        ListThread listThread7 = new ListThread(integers);

        listThread0.start();
        listThread1.start();
        listThread2.start();
        listThread3.start();
        listThread4.start();
        listThread5.start();
        listThread6.start();
        listThread7.start();

        listThread0.join();
        listThread1.join();
        listThread3.join();
        listThread2.join();
        listThread4.join();
        listThread5.join();
        listThread6.join();
        listThread7.join();

        System.out.println(integers);
    }
}
