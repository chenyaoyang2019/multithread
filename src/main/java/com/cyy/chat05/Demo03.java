package com.cyy.chat05;

import java.util.concurrent.TimeUnit;

/**
 * @author: chenyaoyang
 * @date: 2021/12/14 11:07
 * @description: TODO
 **/
public class Demo03 {

    public static class T extends Thread {
        @Override
        public void run() {
            while (true) {
                //循环处理业务
                //模拟阻塞代码
                try {
                    TimeUnit.SECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    this.interrupt();
                }

                if (this.isInterrupted()) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.start();
        TimeUnit.SECONDS.sleep(3);
        t.interrupt();

    }
}
