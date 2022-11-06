package com.lgy;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *
 */
public class ReflectionTest {

    @Test
    public void test1(){
        // 1. 反射之前
        Person p1 = new Person();
        p1.age = 10;
    }


    @Test
    public void test2() throws Exception{
        // 1. 反射之后
        Class clazz = Person.class;
        // 通过反射，来获取 Person 类的对象
        Constructor constructor = clazz.getConstructor(String.class, int.class);
        Person person = (Person) constructor.newInstance("lgy", 24);
        System.out.println(person.toString());

        Field age = clazz.getDeclaredField("age");
        age.set(person,10);
        System.out.println(person.toString());

        Method show = clazz.getDeclaredMethod("show");
        show.invoke(person);

    }


}
