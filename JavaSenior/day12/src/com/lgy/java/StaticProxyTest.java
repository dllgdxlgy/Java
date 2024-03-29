package com.lgy.java;

/**
 *
 * 静态代理举例
 *
 * 特点：代理类和被代理类在编译期间就确定了
 * @author LGY
 * @create 2021-10-04 10:55
 */
//创建一个接口
interface ClothFactory{

    void produceCloth();

}
//被代理类
class NikeFactory implements ClothFactory{

    @Override
    public void produceCloth() {

        System.out.println("Nike工程生产一批运动服");
    }
}

//代理类
//代理类也实现相同的接口
class ProxyClothFactory implements ClothFactory{


    private ClothFactory factory;//用被代理类的对象进行实例化

    //构造器
    public ProxyClothFactory(ClothFactory factory){

        this.factory = factory;
    }
    @Override
    public void produceCloth() {

        System.out.println("代理工厂做一些准备工作");
        factory.produceCloth();
        System.out.println("代理工厂做一些后续的收尾工作");
    }
}




/**
 * 测试
 */
public class StaticProxyTest {

    public static void main(String[] args) {

        //被代理类生成的对象
        ClothFactory nikeFactory = new NikeFactory();
        //传被代理类的对象，创建代理类的对象
        ClothFactory proxyClothFactory = new ProxyClothFactory(nikeFactory);
        //执行方法
        // 代理类的对象执行方法，里面封装类 被代理类 的方法。
        proxyClothFactory.produceCloth();
    }



}
