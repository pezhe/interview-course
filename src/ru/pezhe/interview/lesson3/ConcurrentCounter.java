package ru.pezhe.interview.lesson3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentCounter {

    long counter;
    Lock lock = new ReentrantLock();

    public ConcurrentCounter() {
        counter = 0L;
    }

    void increase() {
        lock.lock();
        try {
            counter++;
        } finally {
            lock.unlock();
        }
    }

}
