package com.cyy.chat06;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: chenyaoyang
 * @date: 2021/12/14 11:35
 * @description: TODO
 **/
public class Demo03 {

    private static int num = 0;

    private static ReentrantLock lock = new ReentrantLock();

    private static void add() {
        lock.lock();
        lock.lock();
        try {
            num++;
        } finally {
            lock.unlock();
            lock.unlock();
        }
    }

    public static class T extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                add();
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        T t1 = new T();
        T t2 = new T();
        T t3 = new T();

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println(num);
    }
}
