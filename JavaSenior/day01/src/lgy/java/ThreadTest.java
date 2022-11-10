package lgy.java;

/**
 * @author LGY
 * @create 2022-11-08 15:26
 */

class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
public class ThreadTest {
    public static void main(String[] args) {
        MyThread thread = new MyThread(); // 主线程做的
        thread.start(); //
        MyThread thread1 = new MyThread();
        thread1.start();

        System.out.println("你好"); // 主线程做的
    }


}
