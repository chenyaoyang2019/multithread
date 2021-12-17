package com.cyy.chat10;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author: chenyaoyang
 * @date: 2021/12/15 12:19
 * @description: TODO
 **/
public class Demo02 {
    public static class T extends Thread {
        int sleepSeconds;
        CountDownLatch countDownLatch;
        public T(String name, int sleepSeconds, CountDownLatch countDownLatch) {
            super(name);
            this.sleepSeconds = sleepSeconds;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            Thread thread = Thread.currentThread();
            long startTime = System.currentTimeMillis();
            System.out.println(startTime + "，" + thread.getName() + "，开始处理");
            try {
                //模拟耗时操作，休眠sleepSeconds
                TimeUnit.SECONDS.sleep(sleepSeconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }

            long endTime = System.currentTimeMillis();
            System.out.println(endTime + "，" + thread.getName() + "，处理完毕，耗时" + (endTime - startTime));
        }
    }
    public static void main(String[] args) throws InterruptedException {
        System.out.println(System.currentTimeMillis() + "，" + Thread.currentThread().getName() + "线程 start");
        CountDownLatch countDownLatch = new CountDownLatch(2);
        long startTime = System.currentTimeMillis();
        T t1 = new T("解析sheet1线程", 2, countDownLatch);
        t1.start();
        T t2 = new T("解析sheet2线程", 5, countDownLatch);
        t2.start();
        countDownLatch.await();
        System.out.println(System.currentTimeMillis() + "，" + Thread.currentThread().getName() + "线程 start");
        long endTime = System.currentTimeMillis();
        System.out.println("总耗时：" + (endTime - startTime));
    }
}
