package com.cyy.demo;

import java.util.concurrent.*;

/**
 * @author: chenyaoyang
 * @date: 2021/12/7 17:37
 * @description: TODO
 **/
public class StarvationDemo {

    private static ExecutorService single = Executors.newSingleThreadExecutor();

    public static class MyCallable1 implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("MyCallable1");
            Future<String> submit = single.submit(new MyCallable2());
            return "success：" + submit.get();
        }
    }

    public static class MyCallable2 implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("MyCallable2");
            return "MyCallable2";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable1 task = new MyCallable1();
        Future<String> submit = single.submit(task);
        System.out.println(submit.get());
        System.out.println("end");
        single.shutdown();
    }

}
