package com.cyy.chat01;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author: chenyaoyang
 * @date: 2021/12/10 11:09
 * @description: TODO
 **/
public class Demo01 {

//    public static void main(String[] args) throws InterruptedException {
//        Thread thread1 = new Thread() {
//            @Override
//            public void run() {
//                System.out.println("start");
//                boolean flag = true;
//                while (flag){
//                    ;
//                }
//                System.out.println("end");
//            }
//        };
//
//        thread1.setName("thread1");
//        thread1.start();
//        //当前线程休眠1秒
//        TimeUnit.SECONDS.sleep(1);
//        //关闭线程thread1
//        thread1.stop();
//        //输出线程thread1的状态
//        System.out.println(thread1.getState());
//
//        //当前线程休眠1秒
//        TimeUnit.SECONDS.sleep(1);
//        //关闭线程thread1
//        thread1.stop();
//        //输出线程thread1的状态
//        System.out.println(thread1.getState());
//    }

//    public static void main(String[] args) throws InterruptedException {
//        Thread thread1 = new Thread() {
//            @Override
//            public void run() {
//                System.out.println("start");
//                while (true){
//                    if (this.isInterrupted()) {
//                        System.out.println("我要退出了！");
//                        break;
//                    }
//                    System.out.println("我执行了");
//                }
//                System.out.println("end");
//            }
//        };
//
//        thread1.setName("thread1");
//        thread1.start();
//        //当前线程休眠1秒
//        TimeUnit.SECONDS.sleep(1);
//        //中断线程thread1
//        thread1.interrupt();
//        //输出线程thread1的状态
//        System.out.println(thread1.getState());
//
//        TimeUnit.SECONDS.sleep(1);
//        System.out.println(thread1.getState());
//
//    }

//    static volatile boolean isStop = false;
//    public static void main(String[] args) throws InterruptedException {
//        Thread thread1 = new Thread() {
//            @Override
//            public void run() {
//                System.out.println("start");
//                while (isStop){
//                    if (this.isInterrupted()) {
//                        System.out.println("我要退出了！");
//                        break;
//                    }
//                    System.out.println("我执行了");
//                }
//                System.out.println("end");
//            }
//        };
//
//        thread1.setName("thread1");
//        thread1.start();
//        //当前线程休眠1秒
//        TimeUnit.SECONDS.sleep(1);
//        //中断线程thread1
//        isStop = true;
//        //输出线程thread1的状态
//        System.out.println(thread1.getState());
//
//    }

//        public static void main(String[] args) throws InterruptedException {
//        Thread thread1 = new Thread() {
//            @Override
//            public void run() {
//                System.out.println("start");
//                while (true){
//                    try {
//                        TimeUnit.SECONDS.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("我要退出了！");
//                    break;
//                }
//                System.out.println("end");
//            }
//        };
//
//        thread1.setName("thread1");
//        thread1.start();
//        //当前线程休眠1秒
//        TimeUnit.SECONDS.sleep(1);
//        //中断线程thread1
//        thread1.interrupt();
//        //输出线程thread1的状态
//        System.out.println(thread1.getState());
//
//
//    }

//    public static void main(String[] args) throws InterruptedException {
//        Thread thread1 = new Thread() {
//            @Override
//            public void run() {
//                System.out.println("start");
//                while (true){
//                    try {
//                        TimeUnit.SECONDS.sleep(100);
//                    } catch (InterruptedException e) {
//                        this.interrupt();
//                        e.printStackTrace();
//                    }
//                    if (this.isInterrupted()) {
//                        System.out.println("我要退出了！");
//                        break;
//                    }
//
//                }
//                System.out.println("end");
//            }
//        };
//
//        thread1.setName("thread1");
//        thread1.start();
//        //当前线程休眠1秒
//        TimeUnit.SECONDS.sleep(1);
//        //中断线程thread1
//        thread1.interrupt();
//        //输出线程thread1的状态
//        System.out.println(thread1.getState());
//
//
//    }
public static void main(String[] args) {

}

}
