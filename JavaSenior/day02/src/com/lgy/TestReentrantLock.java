package com.lgy;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LGY
 * @create 2022-04-12 21:14
 */
public class TestReentrantLock {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        // 银行办理业务的案例来模拟 AQS 如何进行线程管理和通知唤醒机制

        // 3个线程 来模拟 3 个银行客户，受理窗口办理业务

        // A 顾客是第一个顾客，此时A 可以直接去办理
        new Thread(()->{
            lock.lock();
            try {
                System.out.println("-------A Thread come in-----");
                try {
                    TimeUnit.MINUTES.sleep(20);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }finally {
                lock.unlock();
            }

        },"A").start();

        // 第二个顾客 B 、 由于只能一个线程持有锁，此时只能进行等待。
        new Thread(()->{
            lock.lock();
            try {
                System.out.println("-------B Thread come in-----");

            }finally {
                lock.unlock();
            }

        },"B").start();

        // 第三个顾客 C
        new Thread(()->{
            lock.lock();
            try {
                System.out.println("-------C Thread come in-----");

            }finally {
                lock.unlock();
            }

        },"C").start();

    }
}
