package com.lgy.java;

import org.junit.Test;

import java.util.*;

/**
 * @author LGY
 * @create 2021-09-05 14:50
 */
public class TreeMapTest {

    //向TreeMap中添加key-value ,要求key必须是同一个类创建的对象

    //自然排序
    @Test
    public void Test1(){

        TreeMap treeMap = new TreeMap();
        User user1 = new User("lgy",23);
        User user2 = new User("xm",17);
        User user3 = new User("zs",20);
        User user4 = new User("yh",19);

        treeMap.put(user1,98);
        treeMap.put(user2,87);
        treeMap.put(user3,66);
        treeMap.put(user4,100);

        Set set1 = treeMap.entrySet();
        Iterator iterator1 = set1.iterator();
        while (iterator1.hasNext()){
            Object obj = iterator1.next();
            //强转
            Map.Entry entry = (Map.Entry) obj;

            System.out.println(entry.getKey()+ "------>"+entry.getValue());

        }

    }

    //定制排序
    @Test
    public void test2(){

        TreeMap treeMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User){
                    User user1 = (User) o1;
                    User user2 = (User) o1;
                    return Integer.compare(user1.getAge(),user2.getAge());
                }throw new RuntimeException("输入的类型不匹配");

            }
        });
        User user1 = new User("lgy",23);
        User user2 = new User("xm",17);
        User user3 = new User("zs",20);
        User user4 = new User("yh",19);

        treeMap.put(user1,98);
        treeMap.put(user2,87);
        treeMap.put(user3,66);
        treeMap.put(user4,100);

        Set set1 = treeMap.entrySet();
        Iterator iterator1 = set1.iterator();
        while (iterator1.hasNext()){
            Object obj = iterator1.next();
            //强转
            Map.Entry entry = (Map.Entry) obj;

            System.out.println(entry.getKey()+ "------>"+entry.getValue());

        }



    }


}
