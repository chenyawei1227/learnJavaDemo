package com.learnjava.reflection;

import org.junit.Test;
import sun.security.jca.GetInstance;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: chenyawei
 * @Date: 2020-05-27  14:34
 * @Description:
 */
public class ReflectionDemo {

    @Test
    public void test1() {
        Object demo1Bo = (Demo_1_BO)GetClassDemo(Demo_1_BO.class);
        System.out.println(demo1Bo.toString() + " " + ((Demo_1_BO) demo1Bo).getPeopleNum());

    }


    public  Object GetClassDemo(Class clazz){
        try {
            Constructor constructor = clazz.getConstructor();
            Object object = constructor.newInstance();
            Field field = clazz.getDeclaredField("peopleNum");
            field.setAccessible(true);
            field.set(object,888);

            Method method = object.getClass().getMethod("getPeopleNum");
            Object invoke = method.invoke(object);

            System.out.println(invoke);

            return (Object) object;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        return clazz;
    }
}
