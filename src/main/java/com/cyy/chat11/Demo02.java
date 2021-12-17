package com.cyy.chat11;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author: chenyaoyang
 * @date: 2021/12/16 12:22
 * @description: TODO
 **/public class Demo02 {

     public static CyclicBarrier cyclicBarrier = new CyclicBarrier(10);

     public static class T extends Thread {
         int sleep;

         public T(String name, int sleep) {
             super(name);
             this.sleep = sleep;
         }

         //等待吃放
         void eat() {
             try {
                 //模拟休眠
                 TimeUnit.SECONDS.sleep(sleep);
                 long startTime = System.currentTimeMillis();
                 //调用await()的时候，当前线程会被阻塞，需要等待其他员工都到达await才能继续
                 cyclicBarrier.await();
                 long endTime = System.currentTimeMillis();
                 System.out.println(this.getName() + "，sleep:" + this.sleep + " 等待了" + (endTime - startTime) + "（ms）开始吃饭了！");

                 //休眠sleep时间，模拟当前员工吃饭耗时
//                 TimeUnit.SECONDS.sleep(sleep);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             } catch (BrokenBarrierException e) {
                 e.printStackTrace();
             }
         }

         //等待所有人到齐之后，开车去下一站
         void drive() {
             try {
                 //模拟休眠
                 TimeUnit.SECONDS.sleep(sleep);
                 long startTime = System.currentTimeMillis();
                 //调用await()的时候，当前线程会被阻塞，需要等待其他员工都到达await才能继续
                 cyclicBarrier.await();
                 long endTime = System.currentTimeMillis();
                 System.out.println(this.getName() + "，sleep:" + this.sleep + " 等待了" + (endTime - startTime) + "（ms），去下一站景点的路上！");
             } catch (InterruptedException e) {
                 e.printStackTrace();
             } catch (BrokenBarrierException e) {
                 e.printStackTrace();
             }
         }

         @Override
         public void run() {
            //等待所有人到齐之后吃饭，先到的人坐那等着，什么事也不干
             eat();
             //等待所有人到齐之后开车去下一站景点，先到的人坐那等着，什么事也不干
             drive();
         }
     }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            new T("员工" + i, i).start();
        }
    }
}
