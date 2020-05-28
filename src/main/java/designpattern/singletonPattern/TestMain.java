package designpattern.singletonPattern;

/**
 * @Author: chenyawei
 * @Date: 2020-05-05  13:08
 * @Description:
 */
public class TestMain {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getSingleton();
        Singleton singleton1 = Singleton.getSingleton();
        singleton.print();
        singleton1.print2();
        System.out.println(singleton.equals(singleton1));


        GeneralClass generalClass = GeneralClass.getInstance();
        GeneralClass generalClass2 = new GeneralClass();
        generalClass.print();
        generalClass2.print2();
        System.out.println(generalClass.equals(generalClass2));

    }
}
