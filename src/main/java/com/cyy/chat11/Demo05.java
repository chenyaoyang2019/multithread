package com.cyy.chat11;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author: chenyaoyang
 * @date: 2021/12/16 12:22
 * @description: TODO
 **/public class Demo05 {

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
                 if (this.getName().equals("员工1")) {
                     cyclicBarrier.await(5, TimeUnit.SECONDS);
                 } else {
                     cyclicBarrier.await();
                 }


             } catch (InterruptedException e) {
                 e.printStackTrace();
             } catch (BrokenBarrierException e) {
                 e.printStackTrace();
             } catch (TimeoutException e) {
                 e.printStackTrace();
             }
             endTime = System.currentTimeMillis();
             System.out.println(this.getName() + "，sleep:" + this.sleep + " 等待了" + (endTime - startTime) + "（ms）开始吃饭了！");
         }
     }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 10; i++) {

            T t = new T("员工" + i, i);
            t.start();
        }

    }
}
