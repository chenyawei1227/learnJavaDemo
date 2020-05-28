package com.learnjava.demo;

/**
 * @Author: chenyawei
 * @Date: 2020-04-30  10:58
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        int i = 0;
        //test.fetmin(i);
        i = i++;
        System.out.println(i+"==");
    }

    private void fetmin(int i) {
        i++;
    }
}
