package com.atguigu.java;

import org.junit.Test;

import java.io.InputStream;
import java.util.Properties;

/**
 * 了解类的加载器
 * @author shkstart
 * @create 2019 下午 2:16
 */
public class ClassLoaderTest {

//    了解
    @Test
    public void test1(){
        //对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);

        //调用系统类加载器的getParent()：获取扩展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);

        //调用扩展类加载器的getParent()：无法获取引导类加载器
        //引导类加载器主要负责加载java的核心类库，无法加载自定义类的。
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);

        ClassLoader classLoader3 = String.class.getClassLoader();//像string这样的是引导类进行加载的
        System.out.println(classLoader3);

    }


    /*
    Properties：用来读取配置文件。
     */
    @Test
    public void test2() throws Exception {

        //读取配置文件 方式一
        //此时的文件默认在当前的module下。如果是Eclipse，那就是当前工程下。
//        Properties pros =  new Properties();
//        FileInputStream fis = new FileInputStream("jdbc.properties");
//        pros.load(fis);

        //使用这种方式加载jdbc1文件
//        FileInputStream fis = new FileInputStream("src\\jdbc1.properties");//但是使用src\\jdbc1.properties是可以和方式二一样的
//        pros.load(fis);

//        String user = pros.getProperty("user");
//        String password = pros.getProperty("password");
//        System.out.println("user = " + user + ",password = " + password);

        //配置文件不建议写在工程下或这model下，因为部署到tomcat服务器下时，这种配置文件就会缺失了

//        FileInputStream fis = new FileInputStream("src\\jdbc1.properties");//但是使用src\\jdbc1.properties是可以和方式二一样的
//        pros.load(fis);

        //读取配置文件的方式二：使用ClassLoader
        //配置文件默认识别为：当前module的src下
        Properties pros =  new Properties();
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");
        pros.load(is);
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        System.out.println("user = " + user + ",password = " + password);



    }

}
