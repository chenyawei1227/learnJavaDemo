package com.learnjava.lambda;

/**
 * @Author: chenyawei
 * @Date: 2019-12-19 10:18
 */
public class RunnableTest {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("AAA");
            }
        }, "AAA").start();

        new Thread(() -> {
            System.out.println("lambda-AAA");
        }, "AAA-2").start();


        Runnable ru = new Runnable() {
            @Override
            public void run() {
                System.out.println("BBB");
            }
        };
        new Thread(ru, "BBB").start();

        Runnable ru2 = () -> System.out.println("lambda-BBB");
        new Thread(ru2, "BBB2").start();
    }
}
