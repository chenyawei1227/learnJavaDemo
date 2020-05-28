package designpattern.singletonPattern;

/**
 * @Author: chenyawei
 * @Date: 2020-05-05  13:07
 * @Description:
 */
public class GeneralClass {
    private static GeneralClass instance;

    public GeneralClass(){

    }
    public static GeneralClass getInstance(){
        if(instance == null){
            instance = new GeneralClass();
        }
        return instance;
    }
    public void print(){
        System.out.println("generalClass_1");
    }

    public void print2(){
        System.out.println("generalClass_2");
    }
}
