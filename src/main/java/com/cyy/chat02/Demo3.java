package com.cyy.chat02;

/**
 * @author: chenyaoyang
 * @date: 2021/12/13 17:51
 * @description: TODO
 **/
public class Demo3 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread());
        System.out.println(Thread.currentThread().getThreadGroup());
        System.out.println(Thread.currentThread().getThreadGroup().getParent());
        System.out.println(Thread.currentThread().getThreadGroup().getParent().getParent());
    }

}
