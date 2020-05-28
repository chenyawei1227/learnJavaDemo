package com.learnjava.JUC;

/**
 * 线程操作类资源，高内聚低耦合
 *
 * @Author: chenyawei
 * @Date: 2019-12-14 20:56
 * @Version: 1.0
 */
public class ThreadDemo1 {

    public static void main(String[] args) {  //main方法自己带资源对外提供服务
        SailTicket ticket = new SailTicket();


        //不要在资源类上实现Runnble,而是在创建线程的时候来操作。为线程与资源类的低耦合
        new Thread(new Runnable() { //匿名内部类方式
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.sail();    //线程操作资源类
                }
            }
        }, "A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.sail();    //线程操作资源类
                }
            }
        }, "B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.sail();    //线程操作资源类
                }
            }
        }, "C").start();

        //Lambda语法方式，写法（开发中推荐使用这种简洁的代码）
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sail();
            }
        }, "AA").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sail();
            }
        }, "BB").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sail();
            }
        }, "CC").start();
    }
}


/**
 * 1. implements 来实现 （效率低，非低耦合，不推荐）
 * 2. 匿名内部类  （推荐）
 * 3. Lambda方式  (非常推荐)
 **/

