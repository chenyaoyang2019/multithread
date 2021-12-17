package com.cyy.chat13;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: chenyaoyang
 * @date: 2021/12/16 20:11
 * @description: TODO
 **/
public class Demo4 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(System.currentTimeMillis() / 1000);
        //任务执行计数器
        AtomicInteger count = new AtomicInteger(1);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(() -> {
            int currentCount = count.getAndIncrement();
            System.out.println(Thread.currentThread().getName());
            System.out.println(System.currentTimeMillis() / 1000 + "第" + currentCount + "次开始执行");
            //模拟异常
            System.out.println(10 / 0);
            System.out.println(System.currentTimeMillis() / 1000 + "第" + currentCount + "次结束执行");
        }, 1, 3, TimeUnit.SECONDS);

        TimeUnit.SECONDS.sleep(5);
        System.out.println(scheduledFuture.isCancelled());
        System.out.println(scheduledFuture.isDone());
    }
}
