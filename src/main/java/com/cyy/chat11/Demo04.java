package com.cyy.chat11;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author: chenyaoyang
 * @date: 2021/12/16 12:22
 * @description: TODO
 **/public class Demo04 {

     public static CyclicBarrier cyclicBarrier = new CyclicBarrier(10);

     public static class T extends Thread {
         int sleep;

         public T(String name, int sleep) {
             super(name);
             this.sleep = sleep;
         }

         @Override
         public void run() {
             long startTime = 0,  endTime = 0;
             try {
                 //模拟休眠
                 TimeUnit.SECONDS.sleep(sleep);
                 startTime = System.currentTimeMillis();
                 //调用await()的时候，当前线程会被阻塞，需要等待其他员工都到达await才能继续
                 System.out.println(this.getName() + "到了！");
                 cyclicBarrier.await();

             } catch (InterruptedException e) {
                 e.printStackTrace();
             } catch (BrokenBarrierException e) {
                 e.printStackTrace();
             }
             endTime = System.currentTimeMillis();
             System.out.println(this.getName() + "，sleep:" + this.sleep + " 等待了" + (endTime - startTime) + "（ms）开始吃饭了！");
         }
     }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 10; i++) {

            int sleep = 0;
            if (i == 10) {
                sleep = 10;
            }
            T t = new T("员工" + i, sleep);
            t.start();
            if (i == 5) {
                //模拟员工5接了个电话，将自己等待吃饭给打断了
                TimeUnit.SECONDS.sleep(1);
                System.out.println(t.getName() + "， 我有点急事， 我先开吃了！");
                t.interrupt();
                TimeUnit.SECONDS.sleep(2);
            }
        }
    }
}
