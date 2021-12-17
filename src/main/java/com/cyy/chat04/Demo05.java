package com.cyy.chat04;

/**
 * @author: chenyaoyang
 * @date: 2021/12/14 10:30
 * @description: TODO
 **/
public class Demo05 {

    //作用于当前类的实例对象
    public synchronized void m1(){}

    //作用于当前类的实例对象
    public synchronized void m2(){}

    //作用于当前类的实例对象
    public void m3(){
        synchronized (this){}
    }

    //作用当前类Class对象
    public static synchronized void m4() {}

    //作用当前类Class对象
    public static void m5() {
        synchronized(Demo05.class) {}
    }

    public static class T extends Thread {
        Demo05 demo05;

        public T(Demo05 demo05) {
            this.demo05 = demo05;
        }

        @Override
        public void run() {
            super.run();
        }
    }

    public static void main(String[] args) {
        Demo05 demo05 = new Demo05();

        Thread t1 = new Thread(() -> {
           demo05.m1();
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            demo05.m2();
        });
        t2.start();

        Thread t3 = new Thread(() -> {
            demo05.m3();
        });
        t3.start();

        Demo05 demo06 = new Demo05();
        Thread t4 = new Thread(() -> {
            demo06.m2();
        });
        t4.start();

        Thread t5 = new Thread(() -> {
            Demo05.m4();
        });
        t5.start();
        Thread t6 = new Thread(() -> {
            Demo05.m5();
        });
        t6.start();

    }
}
