package com.learnjava.JUC;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @Author: chenyawei
 * @Date: 2019-12-15 21:03
 */
public class ThreadDemo7 {
    public static void main(String[] args) {
        //threadPool();
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        ScheduledFuture<Integer> future = null;
        try {
            for (int i = 1; i <= 20; i++) {
                future = executorService.schedule(() -> {
                    System.out.println(Thread.currentThread().getName());
                    return new Random().nextInt(50);
                }, 2, TimeUnit.SECONDS);
                System.out.println("**" + future.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    private static void threadPool() {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        ExecutorService threadPool2 = Executors.newSingleThreadExecutor(); //一直保持一个线程
        ExecutorService threadPool3 = Executors.newCachedThreadPool();  //根据需要程序自己启动线程数
        Future result = null;
        try {
            for (int i = 1; i <= 20; i++) {

//                result = threadPool.submit(new Callable<Integer>() {
//                    @Override
//                    public Integer call() throws Exception {
//                        System.out.print(Thread.currentThread().getName());
//                        return new Random().nextInt(50);
//                    }
//                });

                //Lambda语法
                result = threadPool3.submit(() -> {
                    System.out.print(Thread.currentThread().getName());
                    return new Random().nextInt(50);
                });
                System.out.println("**" + result.get());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool3.shutdown();
        }
    }
}
