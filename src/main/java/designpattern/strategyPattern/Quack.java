package designpattern.strategyPattern;

/**
 * @Author: chenyawei
 * @Date: 2020-04-13  11:54
 * @Description:
 */
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Quack");
    }
}
