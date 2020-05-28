package com.learnjava.JUC;

import sun.net.www.content.text.plain;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: chenyawei
 * @Date: 2019-12-14 22:20
 */
public class SailTicket {
    private int number = 30; //票数

    private Lock lock = new ReentrantLock();


    public void sail() {
        lock.lock(); // block until condition holds
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "出售了第" + number-- + "张票，还剩余" + number + "张票。");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
