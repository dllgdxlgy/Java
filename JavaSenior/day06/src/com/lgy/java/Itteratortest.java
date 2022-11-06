package com.lgy.java;

import com.atguigu.java.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author LGY
 * @create 2021-09-01 09:06
 */
public class Itteratortest {

    @Test
    public void Test2(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        Iterator iterator = coll.iterator();

        while (iterator.hasNext()){

            Object obj = iterator.next();

            if ("tom".equals(obj)){
                iterator.remove();
            }
        }
       iterator = coll.iterator();
       while (iterator.hasNext()){
           System.out.println(iterator.next());
       }

    }

    @Test
    public void Test1(){
        ArrayList coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        Iterator iterator = coll.iterator();
//        Object next = iterator.next();
//        System.out.println(next);

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }
}
