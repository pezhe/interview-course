package ru.pezhe.interview.lesson3;

import java.util.ArrayList;
import java.util.List;

public class CounterTestApp {

    public static void main(String[] args) throws InterruptedException {
        ConcurrentCounter counter = new ConcurrentCounter();
        List<Thread> threads  = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(() -> {
                        for (int j = 0; j < 1000; j++) {
                            counter.increase();
                        }
                    }));
        }
        for (Thread thread : threads) {
            thread.start();
        }
        Thread.sleep(5000);
        System.out.println(counter.counter);
    }

}
