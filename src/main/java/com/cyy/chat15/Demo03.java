package com.cyy.chat15;

import java.util.concurrent.*;

/**
 * @author: chenyaoyang
 * @date: 2021/12/17 12:22
 * @description: TODO
 **/
public class Demo03 {

    static class GoogsModel {
        //商品名称
        String name;
        //购物开始时间
        long startTime;
        //送到时间
        long endTime;

        public GoogsModel(String name, long startTime, long endTime) {
            this.name = name;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public String toString() {
            return name + "， 下单时间[" + startTime + "，" + endTime + "]， 耗时：" + (endTime - startTime);
        }
    }

    /**
     * 将商品搬上楼
     * @param googsModel
     */
    static void moveUP(GoogsModel googsModel) throws InterruptedException {
        //休眠5秒，模拟搬上楼耗时
        TimeUnit.SECONDS.sleep(5);
        System.out.println("将商品搬上楼，商品信息：" + googsModel);
    }

    static Callable<GoogsModel> buyGoods(String name, long costTime) {
        return () -> {
            long startTime = System.currentTimeMillis();
            System.out.println(startTime + "购买" + name + "下单！");
            try {
                //模拟送货耗时
                TimeUnit.SECONDS.sleep(costTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long endTime = System.currentTimeMillis();
            System.out.println(endTime + name + "送到了！");
            return new GoogsModel(name, startTime, endTime);
        };
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        System.out.println(startTime + "开始购物！");

        //创建一个线程池，用来异步下单
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ExecutorCompletionService<GoogsModel> executorCompletionService = new ExecutorCompletionService<>(executorService);
        //异步下单购买冰箱
        executorCompletionService.submit(buyGoods("冰箱", 5));
        //异步下单购买洗衣机
        executorCompletionService.submit(buyGoods("洗衣机", 2));
        //关闭线程池
        executorService.shutdown();

        //购买商品的数量
        int goodsCount = 2;
        for (int i = 0; i < goodsCount; i++) {
            //可以获取到最先到的商品
            GoogsModel googsModel = executorCompletionService.take().get();
            //将最先到的商品送上楼
            moveUP(googsModel);
        }

        long endTime = System.currentTimeMillis();
        System.out.println(endTime + "货物送到家了！");
        System.out.println("总耗时：" + (endTime - startTime));
    }

}
