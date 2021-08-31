package lgy.java;

/**使用实现Runnable接口的方式进行卖票
 *
 *
 * @author LGY
 * @create 2021-08-22 14:45
 */
class Windows1 implements Runnable{

    private int ticket = 100;
    @Override
    public void run() {
        while (true){
            if (ticket> 0){
                System.out.println(Thread.currentThread().getName()+"卖票：票号为："+ticket);
                --ticket;
            }else {
                break;
            }
        }
    }
}

public class WindowsTest1 {

    public static void main(String[] args) {
        Windows1 windows1 = new Windows1();

        Thread thread1 = new Thread(windows1);
        Thread thread2 = new Thread(windows1);
        Thread thread3 = new Thread(windows1);

        thread1.start();
        thread2.start();
        thread3.start();
    }


}
