package designpattern.strategyPattern;

/**
 * @Author: chenyawei
 * @Date: 2020-04-13  12:02
 * @Description:
 */
public class MiniDuckSimulator
{
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performFly();
        mallard.performQuack();
    }
}
