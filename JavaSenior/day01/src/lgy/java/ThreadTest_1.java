package lgy.java;

/**
 * 继承于Thread类的方式
 * 1.创建 一个继承于Thread类的子类
 * 2.重写Thread类的run()方法
 * 3.创建Thread类的子类的对象
 * 4. 通过此对象调用start()方法
 *
 *
 *
 */

class SubThread extends Thread{
    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            if(i%2 == 0){
                System.out.println(Thread.currentThread().getName()+i);
            }
        }
    }
}

public class ThreadTest_1 {

    public static void main(String[] args) {
        SubThread subThread = new SubThread();

        //作用：1. 启动当前线程，2. 调用当前线程的run()方法
        //此方法在一个线程里只能启动一次，但是是可以通过造多个对象进行调用start()方法的
        subThread.start();//此方法是Thread类的方法,


        //如下的操作是在main线程中做的
        for (int i = 0; i < 100; i++) {
            if(i%2 == 0){
                System.out.println("----main ----"+i);
            }
        }








    }



}
