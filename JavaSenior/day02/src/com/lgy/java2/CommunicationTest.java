package com.lgy.java2;

/**
 * @author LGY
 * @create 2022-11-10 18:49
 */

class Number implements Runnable{

    private  int num = 1;
    @Override
    public void run() {
        while(true){
            synchronized (this) {

                notify();


                if(num <= 100){
                    System.out.println(Thread.currentThread().getName()+":"+num);
                    num++;

                    try {

                        //使得调用 wait() 的方法的线程进入阻塞状态,wait() 会自动释放锁
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    break;
                }
            }
        }

    }
}

public class CommunicationTest {

    public static void main(String[] args) {

        Number number = new Number();

        Thread thread1 = new Thread(number);
        Thread thread2 = new Thread(number);

        thread1.setName("线程1：");
        thread2.setName("线程2：");

        thread1.start();
        thread2.start();
    }




}
