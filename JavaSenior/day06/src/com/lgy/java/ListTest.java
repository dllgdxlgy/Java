package com.lgy.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 * @author LGY
 * @create 2021-09-01 10:05
 */
public class ListTest {

    @Test
    public void Test(){
        ArrayList list = new ArrayList();
        list.add("123");
        list.add(123);
        list.add(new Date());

        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        list.remove(1);
        list.set(1,"nanan");
        for(Object obj:list){
            System.out.println(obj);
        }



    }

}
