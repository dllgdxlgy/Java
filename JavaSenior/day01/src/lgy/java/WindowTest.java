package lgy.java;

/**
 *
 * 创建窗口进行卖票，票的总数是100张
 * @author LGY
 * @create 2021-08-22 14:09
 */
class Windows extends  Thread{


//只是解决了3个100张票的问题，静态变量是类的所有对象共享，必须设置静态的，如果不是，
// 那就需要使用第二种方式

    private static int ticket = 100;
    @Override
    public void run() {
        while (true){
            if(ticket>0){
                System.out.println(Thread.currentThread().getName()+":卖票：票号为："+ticket);
                --ticket;
            }else {
                break;
            }

        }
    }
}

public class WindowTest {

    public static void main(String[] args) {


        Windows windows1 = new Windows();
        Windows windows2 = new Windows();
        Windows windows3 = new Windows();

        windows1.start();
        windows2.start();
        windows3.start();
    }
}
