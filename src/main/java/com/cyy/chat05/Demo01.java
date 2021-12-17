package com.cyy.chat05;

import java.util.concurrent.TimeUnit;

/**
 * @author: chenyaoyang
 * @date: 2021/12/14 10:45
 * @description: TODO
 **/
public class Demo01 {

    public volatile static boolean exit = false;

    public static class T extends Thread {

        @Override
        public void run() {
            while (true) {
                //循环处理业务
                if (exit) {
                    break;
                }
            }
        }
    }

    public static void setExit() {
        exit = true;
    }

    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.start();
        TimeUnit.SECONDS.sleep(3);
        setExit();
    }

}
