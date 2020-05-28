package designpattern.singletonPattern;

import com.sun.org.apache.bcel.internal.generic.NEW;
import sun.swing.plaf.synth.DefaultSynthStyle;

/**
 * @Author: chenyawei
 * @Date: 2020-05-05  13:02
 * @Description:
 */
public class Singleton {
    private int a = 0;
    private static Singleton uniqueInstance;
    private Singleton(){

    }
    public static Singleton getSingleton(){
        if(uniqueInstance == null){
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }

    public void print(){
        a++;
        System.out.println("singleton_1");
    }

    public void print2(){
        System.out.println("singleton_2:" + a);
    }
}


