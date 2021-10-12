package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *
 * 调用运行时类的指定结构：属性、方法、构造器
 *
 * @author LGY
 * @create 2021-10-12 08:31
 */
public class RefilctionTest_copy {

    /**
     * 调用属性，主要是获取属性的值，或者是去设置属性的值
     */

    //这种不经常用，不需要掌握
    @Test
    public void testField() throws Exception{
        Class clazz = Person.class;
        //创建一个运行时类的对象
        Person o = (Person) clazz.newInstance();

        //获取指定的属性 （要求运行时类中的属性为public 的）
        //通常不采用此中方式
        Field id = clazz.getField("id");

        //设置当前运行时类的值(参数一：设置那个对象。参数二：设置为多少)
        id.set(o,111);

        //获取当前对象的属性值
        Object o1 = id.get(o);
        System.out.println(o1);
    }


    /*
    如何操作运行时类的指定的属性 --要掌握
     */
    @Test
    public void testField1() throws Exception{

        Class clazz = Person.class;

        Person P = (Person) clazz.newInstance();

        //开发中经常用此方法获取属性，获取指定变量名的属性
        Field name = clazz.getDeclaredField("name");

        //保证当前属性是可以访问的
        name.setAccessible(true);

        name.set(P,"lgy");
        System.out.println(name.get(P));


    }

    /**
     * 如何操作运行时类中指定的方法 - 需要掌握
     *
     */

    @Test
    public void testMethod() throws Exception{

        Class<Person> clazz = Person.class;
        Person person = (Person) clazz.newInstance();


        //参数一：指明获取方法的名称，同名的方法可能是很多，需要指明形参列表
        Method show = clazz.getDeclaredMethod("show", String.class);

        //invoke()方法 两个参数， 参数一：方法的调用者，参数二：给方法形参赋值的形参

        //保证当前方法是可以访问的
        show.setAccessible(true);
        //调用方法

        //invoke()方法的返回值，即为对应类中调用方法的返回值
        Object gaggag = show.invoke(person, "gaggag");
        System.out.println(gaggag);

        System.out.println("*****************************");


        //如何调用静态方法
        // private static void showDesc()
        Method showDesc = clazz.getDeclaredMethod("showDesc");

        showDesc.setAccessible(true);

        //如果调用的没有返回值，则invoke方法shi
        Object invoke = showDesc.invoke(Person.class);
        System.out.println(invoke);

    }


    /**
     * 调用运行时类的构造器 --了解
     */

    @Test
    public void testConstructor() throws Exception{
        Class clazz = Person.class;

        //获取构造器,这里只需要一个参数就行，因为构造器和类名相同
        Constructor declaredConstructor = clazz.getDeclaredConstructor(String.class);

        //保证构造器是可以访问的
        declaredConstructor.setAccessible(true);

        //调用此构造器创建运行时类的构造器

        Person lgy = (Person) declaredConstructor.newInstance("lgy");

        System.out.println(lgy);

    }


}
