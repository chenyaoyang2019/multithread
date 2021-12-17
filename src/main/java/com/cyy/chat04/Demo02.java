package com.cyy.chat04;

/**
 * @author: chenyaoyang
 * @date: 2021/12/13 20:52
 * @description: TODO
 **/
public class Demo02 {
    static int num = 0;

    public static synchronized void add() {
        num++;
    }

    public static class T extends Thread {

        private Demo02 demo02;

        public T(Demo02 demo02) {
            this.demo02 = demo02;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                add();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Demo02 demo02 = new Demo02();
        T t1 = new T(demo02);
        T t2 = new T(demo02);

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(num);
    }
}
