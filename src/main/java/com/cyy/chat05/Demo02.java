package com.cyy.chat05;

import java.util.concurrent.TimeUnit;

/**
 * @author: chenyaoyang
 * @date: 2021/12/14 10:50
 * @description: TODO
 **/
public class Demo02 {
    public static class T extends Thread {
        @Override
        public void run() {
            while (true) {
                //循环处理业务
                if (this.isInterrupted()) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T t1 = new T();
        t1.start();
        TimeUnit.SECONDS.sleep(3);
        t1.interrupt();
    }

}
