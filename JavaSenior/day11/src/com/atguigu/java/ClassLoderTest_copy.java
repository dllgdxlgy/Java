package com.atguigu.java;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Dutlgy
 * @create 2020-11-25-16:23
 */
public class ClassLoderTest_copy {

    //方式一
    //练习：得到配置文件信息
    @Test
    public void test() throws Exception {

        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream("jdbc.properties");
        properties.load(fis);

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        System.out.println("user = "+user+",password = " +password);

    }
    /*
    * 方式二 使用类的加载器进行加载文件
    *
    *
    * */
    @Test
    public void test2() throws Exception {

        Properties properties = new Properties();
        ClassLoader classLoader = ClassLoderTest_copy.class.getClassLoader();

        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");

        properties.load(is);
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        System.out.println("user = "+user+",password = " +password);
    }

}
