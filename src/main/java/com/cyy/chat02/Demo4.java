package com.cyy.chat02;

import java.util.concurrent.TimeUnit;

/**
 * @author: chenyaoyang
 * @date: 2021/12/13 17:37
 * @description: TODO
 **/
public class Demo4 {

    public static class R1 implements Runnable {

        @Override
        public void run() {
            Thread thread = Thread.currentThread();
            System.out.println("所属线程组:" + thread.getThreadGroup().getName() + ", 线程名称：" + thread.getName());
            while (!thread.isInterrupted()) {}
            System.out.println("线程：" + thread.getName() + " 停止了");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadGroup threadGroup1 = new ThreadGroup("thread-group-1");
        Thread thread1 = new Thread(threadGroup1, new Demo1.R1(), "thread1");
        Thread thread2 = new Thread(threadGroup1, new Demo1.R1(), "thread2");
        thread1.start();
        thread2.start();

        ThreadGroup threadGroup2 = new ThreadGroup(threadGroup1,"thread-group-2");
        Thread thread3 = new Thread(threadGroup2, new Demo1.R1(), "thread3");
        Thread thread4 = new Thread(threadGroup2, new Demo1.R1(), "thread4");
        thread3.start();
        thread4.start();
        TimeUnit.SECONDS.sleep(1);

        System.out.println("--------threadGroup1信息------------");
        threadGroup1.list();
        System.out.println("=================================");
        System.out.println("停止线程组：" + threadGroup1.getName() + "中的所有子孙线程");
        threadGroup1.interrupt();
        TimeUnit.SECONDS.sleep(2);
        System.out.println("+++++++++++++threadGroup1停止后，输出信息+++++++++++++++++");
        threadGroup1.list();

    }
}
