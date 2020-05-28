package com.learnjava.lambda;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @Author: chenyawei
 * @Date: 2019-12-19 10:31
 */
@Data
public class ComparableTest implements Comparable<Object> {
    String name;
    int age;

    public ComparableTest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        ComparableTest girl = (ComparableTest) o;
        return this.age - girl.age;
    }
}

class test {
    public static void main(String[] args) {
        List<ComparableTest> list = new ArrayList<ComparableTest>();
        ComparableTest comparableTest;
        for (int i = 0; i < 20; i++) {
            comparableTest = new ComparableTest("person" + String.valueOf(i), new Random().nextInt(50));
            list.add(comparableTest);
        }
        Collections.sort(list); //compareTo方法中定义的根据age的升序比较
        list.forEach(value -> System.out.println(value.toString()));

    }
}

