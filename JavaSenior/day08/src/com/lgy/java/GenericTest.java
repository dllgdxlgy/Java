package com.lgy.java;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author LGY
 * @create 2021-09-06 08:28
 */
public class GenericTest {

    //在集合中使用泛型之前的情况
    @Test
    public void Test1(){

        ArrayList arrayList = new ArrayList();
        //参数就是Object类型，但是在实际问题的时候不一定是这样的

        //需求：存放学生成绩
        arrayList.add(78);
        arrayList.add(76);
        arrayList.add(89);
        arrayList.add(88);

        arrayList.add("小明");

        for (Object obj :arrayList){

            int stuScore = (Integer) obj;
            System.out.println(obj);
        }
    }

    @Test
    public void Test2(){

    }
}
