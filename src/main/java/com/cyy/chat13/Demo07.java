package com.cyy.chat13;

import java.util.concurrent.*;

/**
 * @author: chenyaoyang
 * @date: 2021/12/16 20:56
 * @description: TODO
 **/
public class Demo07 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Integer> submit = executorService.submit(() -> {
            System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName() + ",start");
            TimeUnit.SECONDS.sleep(5);
            System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName() + ",end");
            return 10;
        });
        System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName());
        try {
            System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName() + ",结果：" + submit.get(3, TimeUnit.SECONDS));
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
