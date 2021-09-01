package com.lgy.java;

import com.atguigu.java.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author LGY
 * @create 2021-09-01 09:19
 */
public class ForTest {


    //增强for循环，用于遍历集合和数组

    @Test
    public void Test1(){
        Collection coll =new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        //for(集合中元素的类型 局部变量：集合对象)
        //
        for(Object obj :coll){
            System.out.println(obj);
        }
    }

    @Test
    public void Test2() {

        int[] arr = new int[]{1,2,3,4,5};

        for(int i :arr){
            System.out.println(i);
        }

    }

    @Test
    public void test3() {

        String[] arr = new String[]{"MM", "MM", "MM"};

//        //方式一：普通for赋值
//        for(int i = 0;i < arr.length;i++){
//            arr[i] = "GG";
//        }

        //方式二：增强for循环
        for (String s : arr) {
            s = "GG";
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
