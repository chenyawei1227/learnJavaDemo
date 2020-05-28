package com.learnjava.JUC;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: chenyawei
 * @Date: 2019-12-16 23:12
 */
public class CountBigDataByCountDownLatchTest {

    static CountDownLatch c = new CountDownLatch(2);
    private static int ai1 = 0;
    private static int ai2 = 0;
    private static int n = 2000000000;

    public static void main(String[] args) throws InterruptedException {
        long start = System.nanoTime();
        Thread countThread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < n / 2; i++) {
                    ai1++;
                }
                c.countDown();
            }
        });
        countThread1.start();
        Thread countThread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < n / 2; i++) {
                    ai2++;
                }
                c.countDown();
            }
        });
        countThread2.start();
        c.await();
        System.out.println(ai1 + ai2);
        System.out.println("use " + (System.nanoTime() - start) / (1000 * 1000) + " ms");
    }

}