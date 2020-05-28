package com.learnjava.JUC;

/**
 * @Author: chenyawei
 * @Date: 2019-12-16 23:06
 */
public class CountBigDataByJoinTest {
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
            }
        });
        countThread1.start();
        Thread countThread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < n / 2; i++) {
                    ai2++;
                }
            }
        });
        countThread2.start();
        countThread1.join();
        countThread2.join();
        System.out.println(ai1);
        System.out.println(ai2);
        System.out.println(ai1 + ai2);
        System.out.println("use " + (System.nanoTime() - start) / (1000 * 1000) + " ms");
    }
}
