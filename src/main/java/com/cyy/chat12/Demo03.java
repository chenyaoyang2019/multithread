package com.cyy.chat12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: chenyaoyang
 * @date: 2021/12/16 17:33
 * @description: TODO
 **/
public class Demo03 {
    static class Task implements Runnable, Comparable<Task> {

        private int i;
        private String name;

        public Task(int i, String name) {
            this.i = i;
            this.name = name;
        }

        @Override
        public int compareTo(Task o) {
            return Integer.compare(o.i, this.i);
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "处理" + this.name);
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(1,
                1,
                60L,
                TimeUnit.SECONDS,
                new PriorityBlockingQueue<>());
        for (int i = 0; i < 10; i++) {
            String taskName = "任务" + i;
            executorService.execute(new Task(i, taskName));
        }

        for (int i = 100; i > 90; i--) {
            String taskName = "任务" + i;
            executorService.execute(new Task(i, taskName));
        }
    }
}
