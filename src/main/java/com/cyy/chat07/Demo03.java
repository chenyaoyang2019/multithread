package com.cyy.chat07;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: chenyaoyang
 * @date: 2021/12/14 15:55
 * @description: TODO
 **/
public class Demo03 {

    static ReentrantLock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static class T1 extends Thread {
        @Override
        public void run() {
            lock.lock();
            try {
                condition.await();
            } catch (InterruptedException e) {
                System.out.println("中断标志：" + this.isInterrupted());
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T1 t1 = new T1();
        t1.setName("t1");
        t1.start();

        TimeUnit.SECONDS.sleep(5);
        //给t1发送中断信号
        System.out.println("1、t1中断标志：" + t1.isInterrupted());
        t1.interrupt();
        System.out.println("2、t1中断标志：" + t1.isInterrupted());
    }
}
