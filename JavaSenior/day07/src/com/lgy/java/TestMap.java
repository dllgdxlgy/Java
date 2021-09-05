package com.lgy.java;

import org.junit.Test;

import java.util.*;

/**
 *
 * 添加、删除、修改操作：
 *  Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
 *  void putAll(Map m):将m中的所有key-value对存放到当前map中
 *  Object remove(Object key)：移除指定key的key-value对，并返回value
 *  void clear()：清空当前map中的所有数据
 *  元素查询的操作：
 *  Object get(Object key)：获取指定key对应的value
 *  boolean containsKey(Object key)：是否包含指定的key
 *  boolean containsValue(Object value)：是否包含指定的value
 *  int size()：返回map中key-value对的个数
 *  boolean isEmpty()：判断当前map是否为空
 *  boolean equals(Object obj)：判断当前map和参数对象obj是否相等
 *  元视图操作的方法：
 *  Set keySet()：返回所有key构成的Set集合
 *  Collection values()：返回所有value构成的Collection集合
 *  Set entrySet()：返回所有key-value对构成的Set集合
 * @author LGY
 * @create 2021-09-05 08:18
 */
public class TestMap {



    @Test
    public void test3(){

        Map map = new HashMap();

        //体现的是添加
        map.put("AA",123);
        map.put(45,123);
        map.put("CC",123);
        map.put("DD",123);

        //体现的是修改
        map.put("AA",87);

        System.out.println(map.toString());


        Map map1 = new HashMap();
        map1.put("2",34);
        map1.put("er",122);
        map.putAll(map1);
        System.out.println(map.toString());

        System.out.println("测试移除操作");

        map.remove("er");
        System.out.println(map.toString());
        System.out.println("清空数据");

        map.clear();//是把数据全清空
        System.out.println(map.size());
        System.out.println(map.toString());

    }

    @Test
    public void Test4(){
        Map map = new HashMap();

        map.put("AA",123);
        map.put(45,123);
        map.put("BB",56);

        System.out.println(map.get(233)); //打印null,无该数据。

        boolean b = map.containsKey("BB");
        System.out.println(b);

        boolean b1 = map.containsValue(123);
        System.out.println(b1); //只要是有一个就是true

        //获取当前map中key - value 对的个数，已经测试过size()


    }

    /**
     * 测试元视图操作的方法
     *
     * 元视图操作的方法：
     *  Set keySet()：返回所有key构成的Set集合
     *  Collection values()：返回所有value构成的Collection集合
     *  Set entrySet()：返回所有key-value对构成的Set集合
     */
    @Test
    public void Test5(){

        Map map = new HashMap();

        map.put("AA",123);
        map.put(45,123);
        map.put("BB",56);

        //遍历所有的key： keySet()
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //遍历所有的values();
        Collection collections = map.values();
        for (Object o : collections){
            System.out.println(o);
        }

        //遍历所有的set集合
        Set set1 = map.entrySet();
        Iterator iterator1 = set1.iterator();
        while (iterator1.hasNext()){
            Object obj = iterator1.next();
            //强转
            Map.Entry entry = (Map.Entry) obj;

            System.out.println(entry.getKey()+ "------>"+entry.getValue());

        }







    }



}
