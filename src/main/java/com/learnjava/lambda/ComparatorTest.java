package com.learnjava.lambda;


import lombok.Data;

import java.util.*;

@Data
class Girl {
    String name;
    int age;

    public Girl(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class ComGirl implements Comparator<Girl> {
    @Override
    public int compare(Girl o1, Girl o2) {
        return o1.age - o2.age;
    }
}

/**
 * @Author: chenyawei
 * @Date: 2019-12-19 10:24
 */
public class ComparatorTest {

    public static void main(String[] args) {
        Set<Girl> sets = new TreeSet<>(new ComGirl());
        Girl girl;
        for (int i = 0; i < 50; i++) {
            girl = new Girl("girl" + String.valueOf(i), new Random().nextInt(50));
            sets.add(girl);
        }
        //sets.forEach(value -> System.out.println(value.toString()));
        sets.stream().forEach(System.out::println);


        Set<Girl> sets2 = new TreeSet<>(new Comparator<Girl>() {
            @Override
            public int compare(Girl o1, Girl o2) {
                return o1.age - o2.age;
            }
        });

        // Set<Girl> sets3 =

        sets2.stream().forEach(System.out::println);
    }
}
