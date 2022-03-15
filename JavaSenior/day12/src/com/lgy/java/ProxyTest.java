package com.lgy.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 * 动态代理举例
 * @author LGY
 * @create 2021-10-04 15:15
 */
//接口
interface Human{


    //获取信仰
    String getBelife();
    void eat(String food);

}

//被代理类
class SuperMan implements Human{

    @Override
    public String getBelife() {
        return "i believe i can fly";
    }

    @Override
    public void eat(String food) {

        System.out.println("我喜欢吃："+food);
    }
}

/**
 * 使用动态代理，需要解决的问题：
 * 问题一：如何根据加载内存中的被代理类，动态创建一个代理类及其对象
 * 问题二：当通过代理类的对象调用方法时，如何动态调用被代理类中的同名方法
 */
class ProxyFactory{


    //调用此方法，返回代理类的对象。为了解决问题一
    //返回值Object就是返回的代理类的类型，不能写成具体的某一个类，写具体就写死了
    public static Object getProxyInstance(Object obj){//创建的 被代理类 的对象


        //handler作为参数，会自动调用invoke方法
        MyInvocationhandler handler = new MyInvocationhandler();

        handler.bind(obj);

        //第一个参数：类的加载器，就是获取被代理类的类的加载器，被代理类是什么加载的，那代理类就用一样的类加载器
        //第二个参数：获取被代理类的所有接口，被代理类实现了什么接口，那代理类就实现什么接口。
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);

    }
}

class MyInvocationhandler implements InvocationHandler{

    private Object obj;//赋值时，也需要使用 被代理类 的对象进行赋值

    public void  bind(Object obj){
        this.obj = obj;
    }

    //当我们通过代理类的对象，调用方法a时，就会自动的调用如下的方法
    //将被代理类要执行的方法a 的功能就声明在invoke()中

    /**
     * 当我们通过代理类的对象，调用方法a时，就会自动的调用如下的方法
     *
     * @param proxy 代理类的对象
     * @param method 代理类要执行的方法，就声明在invoke()中
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //代理类对象调用的方法，此方法也就作为被代理类对象要调用的方法。
        Object returnValue = method.invoke(obj,args);
        return returnValue;
    }
}


public class ProxyTest {

    public static void main(String[] args) {

        // 被代理类 的对象
        SuperMan superMan = new SuperMan();

        //proxyInstance就是 代理类 的对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);

        proxyInstance.getBelife();
        proxyInstance.eat("四川麻辣烫");
    }
}
