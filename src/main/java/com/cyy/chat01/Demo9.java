package com.cyy.chat01;

/**
 * @author: chenyaoyang
 * @date: 2021/12/13 17:05
 * @description: TODO
 **/
public class Demo9 {

    public volatile static boolean flag = true;

    public static class T1 extends Thread {

        public T1(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println("线程" + this.getName() + " 开始了");
            while (flag) {
            }
            System.out.println("线程" + this.getName() + " 结束了");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new T1("t1").start();
        //休眠1秒
        Thread.sleep(1000);
        //flag 置为flase

        flag = false;
    }

}
