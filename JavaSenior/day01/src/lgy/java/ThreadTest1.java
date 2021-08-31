package lgy.java;

/**
 *
 * 方式二；
 * 第一步：实现了Runnable接口的类
 * 第二步：实现类去实现Runnable的抽象方法：run()
 * 第三步：创建Thread类子类的对象
 * 第四步：通过此对象调用start()方法
 * @author LGY
 * @create 2021-08-22 14:21
 */

class MyThreads implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2 ==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

public class ThreadTest1 {

    public static void main(String[] args) {
       MyThreads myThreads = new MyThreads();

       Thread thread1 = new Thread(myThreads);

       thread1.start();//起作用有：1.启动线程 2. 调用当前线程里面的run()

       Thread thread2 = new Thread(myThreads);
       thread2.start();
    }


}
