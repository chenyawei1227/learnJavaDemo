package com.learnjava.JUC;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//资源类
class ShareData {
    private int number = 0;

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    //生产者
    public void increment() throws InterruptedException {
        lock.lock();
        try {
            while (number != 0) {
                condition.await();
            }
            ++number;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    //消费者模式
    public void decrement() throws InterruptedException {
        lock.lock();
        try {
            while (number == 0) {
                condition.await();
            }
            --number;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

//    //生产者
//    public synchronized void increment() throws InterruptedException {
//        while (number != 0){
//            this.wait();
//        }
//        ++number;
//        System.out.println(Thread.currentThread().getName() + "\t" + number);
//        this.notifyAll();
//    }
//
//    //消费者模式
//    public synchronized void decrement() throws InterruptedException {
//        while (number == 0){
//            this.wait();
//        }
//        --number;
//        System.out.println(Thread.currentThread().getName() + "\t" + number);
//        this.notifyAll();
//    }
}

/**
 * 题目：有两个线程，实现对初始值为0的一个变量操作，一个线程对变量加一，另一个线程对变量减一，循环10轮
 *
 * @Author: chenyawei
 * @Date: 2019-12-14 20:56
 * @Version: 1.0
 */
public class ThreadDemo3 {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(200);
                    shareData.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "AA").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(300);
                    shareData.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "BB").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(400);
                    shareData.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "CC").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(500);
                    shareData.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "DD").start();
    }
}
