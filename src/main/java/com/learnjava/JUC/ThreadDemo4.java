package com.learnjava.JUC;

import java.util.concurrent.TimeUnit;

class Phone {
    public static synchronized void getIOS() throws Exception {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("***getIOS");
    }

    public synchronized void getAndroid() {
        System.out.println("***getAndriod");
    }

    public void getHello() {
        System.out.println("***getHello");
    }
}

/**
 * 题目 ： 线程8 锁
 *
 * @Author: chenyawei
 * @Date: 2019-12-14 20:56
 * @Version: 1.0
 */
public class ThreadDemo4 {

    public static void main(String[] args) {

        Phone phone = new Phone();
        //Phone phone2 = new Phone();

        new Thread(() -> {
            try {
                phone.getIOS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "AA").start();

        new Thread(() -> {
            try {
                phone.getAndroid();
                // phone.getHello();
                // phone2.getHello();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "BB").start();

    }
}
