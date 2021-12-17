package com.cyy.chat08;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: chenyaoyang
 * @date: 2021/12/14 16:55
 * @description: TODO
 **/
public class Demo05 {
    static ReentrantLock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {

            System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName() + " start!");

            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName() + " 被唤醒!");

        });

        t1.setName("t1");
        t1.start();
        //休眠5秒
        TimeUnit.SECONDS.sleep(5);
        condition.signal();


    }


}
