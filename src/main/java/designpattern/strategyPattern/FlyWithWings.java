package designpattern.strategyPattern;

/**
 * @Author: chenyawei
 * @Date: 2020-04-13  11:49
 * @Description:
 */
public class FlyWithWings implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("I'm flying!!");
    }
}
