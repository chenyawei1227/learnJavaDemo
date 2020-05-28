package com.learnjava.JUC;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyReadWrite {
    private Object object;
    private ReentrantReadWriteLock wrlock = new ReentrantReadWriteLock();

    public void write(Object obj) {
        wrlock.writeLock().lock();
        try {
            this.object = obj;
            System.out.println(Thread.currentThread().getName() + "\t" + object);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            wrlock.writeLock().unlock();
        }
    }

    public void read() {
        wrlock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t" + object);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            wrlock.readLock().unlock();
        }
    }
}

/**
 * 题目： 100个线程读取，1个线程写
 *
 * @Author: chenyawei
 * @Date: 2019-12-15 20:08
 */
public class TreadDemo6 {

    public static void main(String[] args) throws InterruptedException {

        MyReadWrite myReadWrite = new MyReadWrite();

        new Thread(() -> {
            myReadWrite.write("writie......");
        }, "myReadWrite").start();

        Thread.sleep(100); //防止还没有写的时候就读

        for (int i = 1; i <= 100; i++) {
            new Thread(() -> {
                myReadWrite.read();
            }, String.valueOf(i)).start();
        }

        List<String> list = Collections.emptyList();

        // List<Object> s = Collections.emptyList();

    }
}
