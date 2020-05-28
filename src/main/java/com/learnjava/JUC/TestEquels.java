package com.learnjava.JUC;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

/**
 * @Author: chenyawei
 * @Date: 2019-12-16 15:47
 */
public class TestEquels {


    public static void main(String[] args) {
        String sss1 = "aaa";
        String sss2 = new String("aaa");
        System.out.println(sss1 == sss2);
        System.out.println(sss1.equals(sss2));
        sss1.equals(sss2);

        Integer a;
    }

}
