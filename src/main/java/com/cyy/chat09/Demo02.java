package com.cyy.chat09;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author: chenyaoyang
 * @date: 2021/12/15 10:25
 * @description: TODO
 **/
public class Demo02 {
    static Semaphore semaphore = new Semaphore(2);

    public static class T extends Thread {

        public T(String name) {
            super(name);
        }

        @Override
        public void run() {
            Thread thread = Thread.currentThread();
            try {
                semaphore.acquire();
                System.out.println(System.currentTimeMillis() + "," + thread.getName() + "，获取许可！");
                TimeUnit.SECONDS.sleep(3);
                System.out.println(System.currentTimeMillis() + "," + thread.getName() + "，运行结束！");
                System.out.println(System.currentTimeMillis() + "," + thread.getName() + "，当前可用许可数量：" + semaphore.availablePermits());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new T("t-" + i).start();
        }
    }

}
