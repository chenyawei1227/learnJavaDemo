package com.learnjava.JUC;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: chenyawei
 * @Date: 2019-12-16 17:07
 */
public class Test {

    private int num;
    private String data;

    public Test(int num, String data) {
        this.num = num;
        this.data = data;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if ((obj == null) || (obj.getClass() != this.getClass()))
            return false;

        Test test = (Test) obj;
        return num == test.num && (data == test.data || (data != null && data.equals(test.data)));
    }

    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + num;
        hash = 31 * hash + data.hashCode();
        return hash;

    }

    public static void main(String[] args) {

        Map<Test, Integer> map = new HashMap<>();
        Test t1 = new Test(21, "ouym");
        map.put(t1, 1);
        t1.setNum(20);
        System.out.println(map.get(t1));
        Collections.emptyList();

    }

}