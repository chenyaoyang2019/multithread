package com.cyy.chat10;

import java.util.concurrent.TimeUnit;

/**
 * @author: chenyaoyang
 * @date: 2021/12/15 12:08
 * @description: TODO
 **/
public class Demo01 {

    public static class T extends Thread {
        //休眠时间（秒）
        int sleepSeconds;
        public T(String name, int sleepSeconds) {
            super(name);
            this.sleepSeconds = sleepSeconds;
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
            }

            long endTime = System.currentTimeMillis();
            System.out.println(endTime + "，" + thread.getName() + "，处理完毕，耗时" + (endTime - startTime));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        T t1 = new T("解析sheet1线程", 2);
        t1.start();
        T t2 = new T("解析sheet2线程", 5);
        t2.start();

        t1.join();
        t2.join();
        long endTime = System.currentTimeMillis();
        System.out.println("总耗时：" + (endTime - startTime));
    }
}
