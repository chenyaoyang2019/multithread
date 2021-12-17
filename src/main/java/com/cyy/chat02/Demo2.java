package com.cyy.chat02;

import java.util.concurrent.TimeUnit;

/**
 * @author: chenyaoyang
 * @date: 2021/12/13 17:37
 * @description: TODO
 **/
public class Demo2 {

    public static class R1 implements Runnable {

        @Override
        public void run() {
            Thread thread = Thread.currentThread();
            System.out.println("所属线程组:" + thread.getThreadGroup().getName() + ", 线程名称：" + thread.getName());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadGroup threadGroup1 = new ThreadGroup("thread-group-1");
        Thread thread1 = new Thread(threadGroup1, new Demo1.R1(), "thread1");
        Thread thread2 = new Thread(threadGroup1, new Demo1.R1(), "thread2");
        thread1.start();
        thread2.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("threadGroup1活动线程数：" + threadGroup1.activeCount());
        System.out.println("threadGroup1活动线程组：" + threadGroup1.activeGroupCount());
        System.out.println("threadGroup1线程组名称：" + threadGroup1.getName());
        System.out.println("threadGroup1父线程组名称：" + threadGroup1.getParent().getName());
        System.out.println("+++++++++++++++++++");


        ThreadGroup threadGroup2 = new ThreadGroup(threadGroup1,"thread-group-2");
        Thread thread3 = new Thread(threadGroup2, new Demo1.R1(), "thread3");
        Thread thread4 = new Thread(threadGroup2, new Demo1.R1(), "thread4");
        thread3.start();
        thread4.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("threadGroup2活动线程数：" + threadGroup2.activeCount());
        System.out.println("threadGroup3活动线程组：" + threadGroup2.activeGroupCount());
        System.out.println("threadGroup2线程组名称：" + threadGroup2.getName());
        System.out.println("threadGroup2父线程组名称：" + threadGroup2.getParent().getName());

        System.out.println("--------------------");
        System.out.println("threadGroup1活动线程组：" + threadGroup1.activeGroupCount());
        System.out.println("threadGroup1线程组名称：" + threadGroup1.getName());
        System.out.println("++++++++++++++++++++++++++++++");
        threadGroup1.list();
    }
}
