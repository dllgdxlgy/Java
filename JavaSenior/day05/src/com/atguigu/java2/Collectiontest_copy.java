package com.atguigu.java2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Dutlgy
 * @create 2020-12-03-14:47
 */
public class Collectiontest_copy {

    @Test
    public void test1(){
        Collection collection = new ArrayList();
        collection.add("AA");
        collection.add(123);
        System.out.println(collection.size());
    }

}
