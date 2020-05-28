package com.learnjava.JUC;

import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

@FunctionalInterface
interface MyInterface {

    //public void print();

    //java8以后支持接口中定义多个default方法，并且能够有方法体。
    int add(int x, int y);

    default int div(int x, int y) {
        return x / y;
    }

    default int mul(int x, int y) {
        return x * y;
    }

    public static int aaaStatic(int x) {
        int a = 2 * x;
        return 2;
    }

    public static int bbbStatic(int x) {
        int a = 2 * x;
        return 2;
    }

}

@Data
class Apple {

    private String name;
    private String color;
    private double weight;

    public Apple(String name, String color, double weight) {
        this.name = name;
        this.color = color;
        this.weight = weight;
    }

    public static int compareByWeight(Apple a1, Apple a2) {
        double diff = a1.getWeight() - a2.getWeight();
        return new Double(diff).intValue();
    }

    //还有getter setter toString

}

class ConstructionMethodTest {
    public String getString(Supplier<Apple> supplier) {

        return supplier.toString();
    }
}

public class LambdaDemo {

    public static void main(String[] args) {
//
//        Apple apple1 = new Apple("红富士", "Red", 280);
//        Apple apple2 = new Apple("冯心", "Yello", 470);
//        Apple apple3 = new Apple("大牛", "Red", 320);
//        Apple apple4 = new Apple("小小", "Green", 300);
//
//        List<Apple> appleList = Arrays.asList(apple1, apple2, apple3, apple4);

        //lambda 表达式形式
        //appleList.sort((Apple a1, Apple a2) -> {
        //    return new Double(a1.getWeight() - a2.getWeight()).intValue();
        //});

        //静态方法引用形式（可以看出引用方法比上面的更加简单
//        appleList.sort(Apple::compareByWeight);
//
//        appleList.forEach(apple -> System.out.println(apple));


        ConstructionMethodTest test = new ConstructionMethodTest();

        //lambda表达式形式
        System.out.println(test.getString(() -> {
            return new Apple("aaa", "bbb", 300);
        }));

        //构造方法引用形式
        //System.out.println(test.getString(String::new));

    }
}
