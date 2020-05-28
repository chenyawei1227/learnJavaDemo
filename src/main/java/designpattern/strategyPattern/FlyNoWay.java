package designpattern.strategyPattern;

/**
 * @Author: chenyawei
 * @Date: 2020-04-13  11:56
 * @Description:
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can't fly!");
    }
}
