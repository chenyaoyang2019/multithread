package com.cyy.chat03;

/**
 * @author: chenyaoyang
 * @date: 2021/12/13 19:47
 * @description: TODO
 **/
public class Demo1 {

    public static class T1 extends Thread {

        public T1(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println(this.getName() + "开始执行，" + (this.isDaemon() ? "我是守护线程" : "我是用户线程"));
            while (true) {}
        }
    }

    public static void main(String[] args) {
        T1 t1 = new T1("子线程1");
        t1.start();
        System.out.println("主线程结束");
    }
}
