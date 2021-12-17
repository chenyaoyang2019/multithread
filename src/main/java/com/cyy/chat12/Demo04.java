package com.cyy.chat12;

import com.cyy.chat05.Demo01;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: chenyaoyang
 * @date: 2021/12/16 17:43
 * @description: TODO
 **/
public class Demo04 {
    static AtomicInteger threadNum = new AtomicInteger(1);

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,
                5,
                60L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                r -> {
                    Thread thread = new Thread(r);
                    thread.setName("自定义线程：" + threadNum.getAndIncrement());
                    return thread;
                });
        for (int i = 1; i <= 5; i++) {
            String taskName = "任务" + i;
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "处理" + taskName);
            });
        }

        executor.shutdown();
    }
}
