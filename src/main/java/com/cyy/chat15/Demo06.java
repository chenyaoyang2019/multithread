package com.cyy.chat15;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author: chenyaoyang
 * @date: 2021/12/17 15:53
 * @description: TODO
 **/
public class Demo06 {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Callable<Integer>> list = new ArrayList<>();
        int taskCount = 5;
        for (int i = taskCount; i > 0; i--) {
            int j = i * 2;
            String taskName = "任务" + i;
            list.add(() -> {
                TimeUnit.SECONDS.sleep(j);
                System.out.println(taskName + "执行完毕");
                return j;
            });
        }

        Integer integer = executorService.invokeAny(list);
        System.out.println("耗时：" + (System.currentTimeMillis() - startTime) + "，执行结果" + integer);
        executorService.shutdown();
    }

//    public static <T> T invokeAny(Executor executor, Collection<Callable <T>> solvers) throws InterruptedException, ExecutionException {
//        CompletionService<T> executorCompletionService = new ExecutorCompletionService<>(executor);
//        List<Future<T>> futureList = new ArrayList<>();
//
//        for (Callable<T> solver : solvers) {
//            futureList.add(executorCompletionService.submit(solver));
//        }
//        int n = solvers.size();
//        try {
//            for (int i = 0; i < n; ++i) {
//                T t = executorCompletionService.take().get();
//                if (t != null) {
//                    return t;
//                }
//            }
//        } finally {
//            for (Future<T> future : futureList) {
//                future.cancel(true);
//            }
//        }
//        return null;
//    }

}
