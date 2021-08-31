/*

运算符之一：算术运算符
 */
import java.util.Scanner;
public class AriTest {

    public static void main(String[] args) {

        /*
        int num1 = 1;
        int num2 = 12;
        int reault = num2/num1;

        System.out.println(reault);
        double result = num2/(num1+0.0);
        System.out.println(result);

        int num =1;
        num +=2;
        System.out.println(num);

        int a = 23;
        if (a<24){
            System.out.println("可以看成人电影了");

        }else if (a>12){
            System.out.println("还不可以看");
        }
        */


        //如何从键盘获取值，需要使用Scanner类
        //导入包
   /*
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的考试成绩：");
        int num = scanner.nextInt();
        if(num == 100){
            System.out.println("奖励一台宝马");
        }else if (num>80 & num<=99){
            System.out.println("奖励一台iphone");
        }else if (num>60 & num<=80){
            System.out.println("奖励ipad");
        }else {
            System.out.println("啥也没有");
        }
*/
        //如何获取随机数？
        double value = Math.random();//这里面是0～1的随机数
        int value2 = (int)(Math.random()*90+10);//这里面是[10～99]的随机数
        //公式：[a,b]:  (int)(Math.random()*(b-a+1)+a)

        System.out.println(value2);




    }


}

