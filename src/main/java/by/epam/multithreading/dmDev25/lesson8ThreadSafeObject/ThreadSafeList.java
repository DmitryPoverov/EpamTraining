package by.epam.multithreading.dmDev25.lesson8ThreadSafeObject;

import java.util.ArrayList;
import java.util.List;

public class ThreadSafeList {

    private List<Integer> list;

    public ThreadSafeList(List<Integer> list) {
        // this code works only on java 15 and higher: this.list = List.copyOf(list);
        this.list = list;
    }

    public List<Integer> getList() {
        return new ArrayList<>(list);
    }
}
