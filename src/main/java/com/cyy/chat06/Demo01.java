package com.cyy.chat06;

/**
 * @author: chenyaoyang
 * @date: 2021/12/14 11:27
 * @description: TODO
 **/
public class Demo01 {

    private static int num = 0;

    private static synchronized void add() {
        num++;
    }

    public static class T extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                add();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T t1 = new T();
        T t2 = new T();
        T t3 = new T();

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println(num);
    }

}
