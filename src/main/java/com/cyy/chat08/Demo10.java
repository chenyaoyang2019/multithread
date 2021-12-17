package com.cyy.chat08;

import java.util.concurrent.locks.LockSupport;

/**
 * @author: chenyaoyang
 * @date: 2021/12/15 10:10
 * @description: TODO
 **/
public class Demo10 {

    static class BlockDemo {}

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            LockSupport.park();
        });
        t1.setName("t1");
        t1.start();

        Thread t2 = new Thread(() -> {
            LockSupport.park(new BlockDemo());
        });
        t2.setName("t2");
        t2.start();
    }
}
