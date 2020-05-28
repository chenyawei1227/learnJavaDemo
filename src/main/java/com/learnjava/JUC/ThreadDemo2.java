package com.learnjava.JUC;


import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "线程的call......");
        return 200;
    }
}

/**
 * Cabllable
 *
 * @Author: chenyawei
 * @Date: 2019-12-14 20:56
 * @Version: 1.0
 */
public class ThreadDemo2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyCallable());
        new Thread(futureTask, "AA").start();
        HashMap map = new HashMap();

        //Lambda实现方式
        FutureTask<Integer> futureTask1 = new FutureTask<Integer>(() -> {
            System.out.println(Thread.currentThread().getName() + "线程的call......");
            return 300;
        });
        new Thread(futureTask1, "BB").start();
        System.out.println("futureTask1.get() = " + futureTask1.get());
    }
}
