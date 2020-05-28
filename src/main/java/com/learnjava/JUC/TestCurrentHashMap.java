package com.learnjava.JUC;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: chenyawei
 * @Date: 2019-12-16 15:16
 */
public class TestCurrentHashMap {

    public static void main(String[] args) {

        ConcurrentHashMap hashMap = new ConcurrentHashMap();
        hashMap.put("aa", 123123);
        hashMap.put("bb", "charchar");

        System.out.println(hashMap.get("aa"));
        System.out.println(hashMap.get("bb"));
    }
}
