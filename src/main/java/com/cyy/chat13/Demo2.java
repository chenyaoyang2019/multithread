package com.cyy.chat13;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: chenyaoyang
 * @date: 2021/12/16 20:11
 * @description: TODO
 **/
public class Demo2 {

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis() / 1000);
        //任务执行计数器
        AtomicInteger count = new AtomicInteger(1);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            int currentCount = count.getAndIncrement();
            System.out.println(Thread.currentThread().getName());
            System.out.println(System.currentTimeMillis() / 1000+ "第" + currentCount + "次开始执行" );
            //模拟耗时任务
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(System.currentTimeMillis() / 1000 + "第" + currentCount + "次结束执行" );
        }, 1, 1, TimeUnit.SECONDS);

    }
}
