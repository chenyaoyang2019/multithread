package com.cyy.chat06;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: chenyaoyang
 * @date: 2021/12/14 11:42
 * @description: TODO
 **/
public class Demo04 {

    private static int num = 0;

//    private static ReentrantLock fairLock = new ReentrantLock(true);
    private static ReentrantLock unfairLock = new ReentrantLock(false);

    public static class T extends Thread {

        public T(String name) {
            super(name);
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
//                fairLock.lock();
                unfairLock.lock();
                try {
                    System.out.println(this.getName() + " 获得锁！");
                } finally {
//                    fairLock.unlock();
                    unfairLock.unlock();
                }
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        T t1 = new T("t1");
        T t2 = new T("t2");
        T t3 = new T("t3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }
}
