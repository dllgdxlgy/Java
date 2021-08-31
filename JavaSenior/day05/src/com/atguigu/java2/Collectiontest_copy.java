package com.atguigu.java2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * @author Dutlgy
 * @create 2020-12-03-14:47
 */
public class Collectiontest_copy {

    @Test
    public void test1(){

        //add(Object e)将元素e添加到集合中
        Collection collection = new ArrayList();
        collection.add("AA");
        collection.add(123);
        collection.add(new Date());
        System.out.println(collection.size());


        Collection collection1 = new ArrayList();
        collection.add("nihao");
        collection1.addAll(collection);
        System.out.println(collection1.size());

        System.out.println(collection1.isEmpty());
    }

}
