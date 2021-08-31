package lgy.exer;

/**
 *
 * 练习：创建两个线程，一个遍历100以内偶数，一个遍历100以内的奇数。
 * @author LGY
 * @create 2021-08-21 18:00
 */

class SubClass extends Thread{

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){

                System.out.println(Thread.currentThread().getName()+Thread.currentThread().getPriority()+i);
            }
        }
    }
}

class SubClass2 extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0){

                System.out.println(Thread.currentThread().getName()+i);
            }
        }
    }
}

public class ThreadDemo {

    public static void main(String[] args) {
        SubClass subClass = new SubClass();

        SubClass2 subClass2 = new SubClass2();

        subClass.setName("线程-1:");
        subClass2.setName("线程-2");

        subClass.setPriority(10);
        subClass.start();
        subClass2.start();

        Thread.currentThread().setName("主线程");
        System.out.println(Thread.currentThread().getName());

        System.out.println("主线程操作的");
    }

//    public static void main(String[] args) {
//
//        //创建thread类的匿名子类的方式
//        new SubClass(){
//            @Override
//            public void run() {
//
//            }
//        }.start();
//    }


}




