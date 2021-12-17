package com.cyy.chat15;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Consumer;

/**
 * @author: chenyaoyang
 * @date: 2021/12/17 15:53
 * @description: TODO
 **/
public class Demo04 {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Callable<Integer>> list = new ArrayList<>();
        int taskCount = 5;
        for (int i = taskCount; i > 0; i--) {
            int j = i * 2;
            list.add(() -> {
                TimeUnit.SECONDS.sleep(j);
                return j;
            });
        }

        solve(executorService, list, a -> {
            System.out.println(System.currentTimeMillis() + ":" + a);
        });
        executorService.shutdown();
    }

    public static <T> void  solve(Executor executor, Collection<Callable <T>> solvers, Consumer<T> use) throws InterruptedException, ExecutionException {
        CompletionService<T> executorCompletionService = new ExecutorCompletionService<>(executor);
        for (Callable<T> solver : solvers) {
            executorCompletionService.submit(solver);
        }
        int n = solvers.size();
        for (int i = 0; i < n; ++i) {
            T t = executorCompletionService.take().get();
            if (t != null) {
                use.accept(t);
            }
        }
    }

}
