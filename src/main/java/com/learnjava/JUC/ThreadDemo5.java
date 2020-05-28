package com.learnjava.JUC;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareResource {
    private int flag = 1; // 1-A, 2-B, 3-C
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void print5(int totalLoop) {
        lock.lock();
        try {
            //判断
            while (flag != 1) {
                condition1.await();
            }
            //干活
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\ttotalLoop: " + totalLoop);
            }
            //通知+唤醒
            flag = 2;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10(int totalLoop) {
        lock.lock();
        try {
            //判断
            while (flag != 2) {
                condition2.await();
            }
            //干活
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\ttotalLoop: " + totalLoop);
            }
            //通知+唤醒
            flag = 3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15(int totalLoop) {
        lock.lock();
        try {
            //判断
            while (flag != 3) {
                condition3.await();
            }
            //干活
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\ttotalLoop: " + totalLoop);
            }
            //通知+唤醒
            flag = 1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

/**
 * 题目：有ABC三个线程，A线程打印5次，B线程打印10次，C线程打印15次，然后，在同样的顺序打印第2轮，总共打印10轮
 *
 * @Author: chenyawei
 * @Date: 2019-12-15 19:24
 */
public class ThreadDemo5 {
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                shareResource.print5(i);
            }
        }, "AA").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                shareResource.print10(i);
            }
        }, "BB").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                shareResource.print15(i);
            }
        }, "CC").start();
    }
}
