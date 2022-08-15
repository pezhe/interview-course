package ru.pezhe.interview.lesson2;

import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {
    @SuppressWarnings("unchecked")
    private T[] array = (T[]) new Object[5];
    private int size;

    public void add(T item) {
        ensureCapacity();
        array[size++] = item;
    }

    public void add(int index, T item) {
        checkRange(index);
        ensureCapacity();
        System.arraycopy(array, index, array, index + 1,size - index);
        array[index] = item;
        size++;
    }

    private void checkRange(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + "; Size: " + size);
        }
    }

    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (size == array.length) {
            T[] newArray = (T[]) new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }


    public T remove(int index) {
        checkRange(index);
        T item = array[index];
        size--;
        System.arraycopy(array, index + 1, array, index, size - index);
        return item;
    }

    public T get(int index) {
        checkRange(index);
        return array[index];
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyArrayListIterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            if (i != 0) sb.append(" ");
            sb.append(array[i].toString());
        }
        sb.append("]");
        return sb.toString();
    }

    private class MyArrayListIterator implements Iterator<T> {

        int cursor;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public T next() {
            return array[cursor++];
        }

    }

}
