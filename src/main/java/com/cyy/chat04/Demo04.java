package com.cyy.chat04;


/**
 * @author: chenyaoyang
 * @date: 2021/12/14 10:06
 * @description: TODO
 **/
public class Demo04 implements Runnable{

    static Demo04 instance = new Demo04();

    static int num = 0;

    @Override
    public void run() {
        //省略其他耗时的操作
        //使用同步代码块对变量i进行同步操作，锁对象为instance
        synchronized (instance) {
            for (int i = 0; i < 10; i++) {
                num++;
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(num);
    }
}
