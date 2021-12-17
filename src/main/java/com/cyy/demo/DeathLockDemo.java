package com.cyy.demo;

/**
 * @author: chenyaoyang
 * @date: 2021/12/7 17:23
 * @description: TODO
 **/
public class DeathLockDemo {

    public static void main(String[] args) {
        A1 a1 = new A1();
        A2 a2 = new A2();
        Thread thread1 = new Thread(new SynAndRunnable(a1, a2, 1, 2, true));
        thread1.setName("thread1");
        thread1.start();
        Thread thread2 = new Thread(new SynAndRunnable(a1, a2, 2, 1, false));
        thread2.setName("thread2");
        thread2.start();
    }


    /**
     * 线程等待示例
     */
    public static class SynAndRunnable implements Runnable {
        A1 a1;
        A2 a2;
        int a, b;
        boolean flag;
        public SynAndRunnable(A1 a1, A2 a2, int a, int b, boolean flag) {
            this.a1 = a1;
            this.a2 = a2;
            this.a = a;
            this.b = b;
            this.flag = flag;
        }

        @Override
        public void run() {
            try{
                if (flag) {
                    synchronized (a1) {
                        Thread.sleep(100);
                        synchronized (a2) {
                            System.out.println(a + b);
                        }
                    }
                } else {
                    synchronized (a2) {
                        Thread.sleep(100);
                        synchronized (a1) {
                            System.out.println(a + b);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static class A1{}
    public static class A2{}
}
