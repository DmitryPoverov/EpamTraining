package by.epam.multithreading.dmDev25.lesson8ThreadSafeObject;

import java.util.ArrayList;
import java.util.List;

public class ThreadSafeDemo {
    public static void main(String[] args) {

        ThreadSafeList list = new ThreadSafeList(new ArrayList<>());

        List<Integer> list1 = list.getList();
        list1.add(1);

        System.out.println(list.getList());
    }
}