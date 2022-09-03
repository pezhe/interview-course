package ru.pezhe.interview.lesson3;

public class PingPongApp {

    public static void main(String[] args) {

        Object lock = new Object();

        new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    try {
                        System.out.println("Ping");
                        Thread.sleep(500);
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    try {
                        System.out.println("Pong");
                        Thread.sleep(500);
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();
    }

}
