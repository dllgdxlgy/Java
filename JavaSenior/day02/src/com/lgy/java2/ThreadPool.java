package com.lgy.java2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author LGY
 * @create 2022-11-11 21:03
 */

class NumberThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+" : " + i);
            }
        }
    }
}
public class ThreadPool {

    public static void main(String[] args) {

        // 提供指定数量的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        //在这里可以设置线程池的属性
        System.out.println(executorService.getClass());

        // 提供指定的线程的操作，需要提供实现 Runnable() 接口实现类的对象
        NumberThread thread = new NumberThread();
        executorService.execute(thread); // 适合 Runable()
//        executorService.submit(); //  适合Callable()

        // 关闭线程池
        executorService.shutdown(); //
    }
}
