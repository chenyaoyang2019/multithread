package com.cyy.chat12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author: chenyaoyang
 * @date: 2021/12/16 17:24
 * @description: TODO
 **/
public class Demo02 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 50; i++) {
            int j = i;
            String taskName = "任务" + j;
            executorService.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "处理" + taskName);
                //模拟任务内部处理耗时
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            });
        }
        executorService.shutdown();
    }
}
