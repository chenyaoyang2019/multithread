package com.cyy.chat08;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: chenyaoyang
 * @date: 2021/12/14 16:55
 * @description: TODO
 **/
public class Demo06 {
    static ReentrantLock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
            System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName() + " start!");
            try {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName() + " 被唤醒!");
            } finally {
                lock.unlock();
            }
        });

        t1.setName("t1");
        t1.start();
        //休眠1秒
        TimeUnit.SECONDS.sleep(1);
        lock.lock();
        try {
            condition.signal();
        } finally {
            lock.unlock();
        }
        System.out.println(System.currentTimeMillis() + ", condition,signal()方法执行完毕");
    }



}
