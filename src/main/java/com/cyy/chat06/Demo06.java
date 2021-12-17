package com.cyy.chat06;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: chenyaoyang
 * @date: 2021/12/14 12:18
 * @description: TODO
 **/
public class Demo06 {

    private static ReentrantLock lock = new ReentrantLock(false);

    public static class T extends Thread {

        public T(String name){
            super(name);
        }
        @Override
        public void run() {
            try {
                System.out.println(System.currentTimeMillis() + ":" + this.getName() + "开始获取锁！");

                if (lock.tryLock()) {
                    System.out.println(System.currentTimeMillis() + ":" + this.getName() + "获取到了锁！");
                    //获取到锁之后，休眠5秒
                    TimeUnit.SECONDS.sleep(5);
                } else {
                    System.out.println(System.currentTimeMillis() + ":" + this.getName() + "未能获取到锁！");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (lock.isHeldByCurrentThread()){
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        T t1 = new T("t1");
        T t2 = new T("t2");
        t1.start();
        t2.start();
    }
}
