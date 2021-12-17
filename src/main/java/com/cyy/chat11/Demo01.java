package com.cyy.chat11;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author: chenyaoyang
 * @date: 2021/12/16 12:22
 * @description: TODO
 **/public class Demo01 {

     public static CyclicBarrier cyclicBarrier = new CyclicBarrier(10);

     public static class T extends Thread {
         int sleep;

         public T(String name, int sleep) {
             super(name);
             this.sleep = sleep;
         }

         @Override
         public void run() {
             try {
                 //模拟休眠
                 TimeUnit.SECONDS.sleep(sleep);
                 long startTime = System.currentTimeMillis();
                 //调用await()的时候，当前线程会被阻塞，需要等待其他员工都到达await才能继续
                 cyclicBarrier.await();
                 long endTime = System.currentTimeMillis();
                 System.out.println(this.getName() + "，sleep:" + this.sleep + " 等待了" + (endTime - startTime) + "（ms）开始吃饭了！");
             } catch (InterruptedException e) {
                 e.printStackTrace();
             } catch (BrokenBarrierException e) {
                 e.printStackTrace();
             }
         }
     }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            new T("员工" + i, i).start();
        }
    }
}
