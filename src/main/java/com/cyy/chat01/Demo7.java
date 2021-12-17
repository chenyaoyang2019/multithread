package com.cyy.chat01;

/**
 * @author: chenyaoyang
 * @date: 2021/12/13 16:29
 * @description: TODO
 **/
public class Demo7 {

    static Object object = new Object();

    public static class T1 extends Thread {

        public T1(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (object) {
                System.out.println("in " + this.getName());
                Thread.currentThread().suspend();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T1 t1 = new T1("t1");
        t1.start();
        Thread.sleep(100);
        T1 t2 = new T1("t2");
        t2.start();
        t1.resume();
        t2.resume();
        t1.join();
        t2.join();
    }



}
