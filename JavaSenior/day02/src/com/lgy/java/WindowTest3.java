package com.lgy.java;

/**
 *
 * 使用同步方法的方式实现Runnable()方式解决接口的线程安全问题
 *
 * @author LGY
 * @create 2021-08-22 15:32
 */
class Window3 implements Runnable{

    private int ticket = 100;

    @Override
    public void run() {
       show();
    }

    public synchronized  void show( ) { //同步监视器就是this
        while(true) {

            if (ticket > 0) {

                try {
                    Thread.sleep(100);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
                ticket--;
            } else {
                break;

            }
        }
    }
}


public class WindowTest3 {
    public static void main(String[] args) {
        Window3 w = new Window3();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }

}