package com.lgy.java;

/**
 * 例子：创建三个窗口卖票，总票数为100张.使用实现Runnable接口的方式
 * 存在线程的安全问题，待解决。
 *
 * 问题出现的原因：当一个线程进如当时还没操作时，这时候又有另一个线程进来了，这时候就会出现线程安全问题
 * 怎么解决：加一个锁，当一个线程进来的时候，另一个线程只能进行等待，当执行完成当前线程的时候，才能执行
 * 后面的线程。
 *
 * 解决的方式：
 * 方式一：同步代码块
 *
 * synchornized（同步监视器）{
 *
 *     //需要同步的代码，操作共享数据的代码即为被同步的方法。
 *     //多个线程共同操作的数据即为共享数据
 * }
 * 方法二：同步方法
 *
 * 如果操作的共享数据在一个方法里，不妨可以将此方法声明为同步的
 *
 * 同步的方式：解决了方式的安全问题，但是在同步代码块中其实是单线程的
 *
 *
 *
 * @author LGY
 * @create 2019-02-13 下午 4:47
 */
class Window1 implements Runnable{

    private int ticket = 100;

    @Override
    public void run() {
        while(true) {
            synchronized(Window1.class) {
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
}


public class WindowTest1 {
    public static void main(String[] args) {
        Window1 w = new Window1();

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
