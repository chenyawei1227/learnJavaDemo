package designpattern.strategyPattern;

/**
 * @Author: chenyawei
 * @Date: 2020-04-13  11:58
 * @Description:
 */
public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Squeak");
    }
}
