/*
根据switch的值，以此匹配各个case中的常量，一旦匹配成功，则进入相应的case，调用其结构。一直执行到遇到关键字break
break，可以使用在switch结构中

switch中的表达式只是如下六种方式之一，byte、short、char、int、枚举类型、String类型
 */

import java.util.Scanner;
public class SwitchTest {
    public static void main(String[] args) {

        /*
        int i =2;
        switch (i){

            case 1:
                System.out.println("1");
                break;//可选的，并不是一定写，也不一定一定不写，根据情况来。
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
                break;
            //可选的，并不一定使用。
            default:
                System.out.println("5");

        }
        */

        /*
        int score = 78;
        switch (score/10){

            case 0:
                System.out.println("不及格");
                break;
            case 1:
                System.out.println("不及格");
                break;
            case 3:
                System.out.println("不及格");
                break;

        }
        */

        //循环结构
        //for循环、while循环、

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入你的第一个正整数:");
        int num1 =  scanner.nextInt();
        System.out.print("请输入你的第二个正整数：");
        int num2 = scanner.nextInt();

        int min = (num1>=num2)?num2:num1;
        for (int i = min;i>=1;i--) {
            if (num1 % i == 0 && num2 % i == 0) {
                System.out.println(i);
                break;
            }

        }

        while (num1<1){

        }
    }
}
