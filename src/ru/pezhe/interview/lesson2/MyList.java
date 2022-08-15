package ru.pezhe.interview.lesson2;

import java.util.Iterator;

public interface MyList<T> extends Iterable<T> {

    void add(T item);
    void add(int index, T item);
    T remove(int index);
    T get(int index);
    int size();
    Iterator<T> iterator();

}
