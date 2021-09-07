package com.atguigu.java;



import org.junit.Test;

import java.util.Random;

/**
 * 通过反射创建对应的运行时类的对象
 *
 * @author shkstart
 * @create 2019 下午 2:32
 */
public class NewInstanceTest {

    @Test
    public void test1() throws IllegalAccessException, InstantiationException {

//        Class clazz = Person.class;
        Class<Person> clazz = Person.class;
        /*
        newInstance():调用此方法，创建对应的运行时类的对象。内部调用了运行时类的空参的构造器。
        如果没有空参构造器就回包上面的异常

        要想此方法正常的创建运行时类的对象，要求：
        1.运行时类必须提供空参的构造器，所以我们经常在写 javabean 时，写上无参构造函数。
        2.空参的构造器的访问权限得够。通常，设置为public。


        在javabean中要求提供一个public的空参构造器。原因：
        1.便于通过反射，创建运行时类的对象
        2.便于子类继承此运行时类时，默认调用super()时，保证父类有此构造器

         */
        Person obj = clazz.newInstance();
        System.out.println(obj);

    }


    //体会反射的动态性
    //一说到反射，就要想到动态性,不像 new 对象一样，这里创建对象是不确定的，体现了动态性
    @Test
    public void test2(){

        for(int i = 0;i < 100;i++){
            int num = new Random().nextInt(3);//形成随机数0,1,2
            String classPath = "";
            switch(num){
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath = "com.atguigu.java.Person";
                    break;
            }

            try {
                Object obj = getInstance(classPath);
                System.out.println(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



    }

    /*
    创建一个指定类的对象。
    classPath:指定类的全类名
     */
    public Object getInstance(String classPath) throws Exception {
       Class clazz =  Class.forName(classPath);
       return clazz.newInstance();
    }

}
