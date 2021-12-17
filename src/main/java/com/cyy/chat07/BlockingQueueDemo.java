package com.cyy.chat07;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: chenyaoyang
 * @date: 2021/12/14 16:20
 * @description: TODO
 **/
public class BlockingQueueDemo<E> {
    int size;

    ReentrantLock lock = new ReentrantLock();

    List<E> list = new LinkedList<>(); //队列底层实现逻辑
    Condition notFull = lock.newCondition();//队列满时的等待条件
    Condition notEmpty = lock.newCondition();//队列空时的等待条件

    public BlockingQueueDemo(int size) {
        this.size = size;
    }

    public void enqueue(E e) throws InterruptedException {
        lock.lock();
        try {
            while (list.size() == size) {//队列已满，在notFull条件上等待
                notFull.await();
            }
            list.add(e);
            System.out.println("入队:" + e);
            notEmpty.signal();
        }finally {
            lock.unlock();
        }
    }

    public E dequeue() throws InterruptedException {
        E e;
        lock.lock();
        try {
            while (list.size() == 0) { //队列为空， 在notEmpty条件上等待
                notEmpty.await();
            }
            e = list.remove(0);//出队，移除链表首元素
            System.out.println("出队：" + e);
            notFull.signal();//通知在notFull条件上等待的线程
            return e;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        BlockingQueueDemo<Integer> queue = new BlockingQueueDemo<>(2);
        for (int i = 0; i < 10; i++) {
            int data = i;
            new Thread(() -> {
                try {
                    queue.enqueue(data);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    Integer dequeue = queue.dequeue();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
