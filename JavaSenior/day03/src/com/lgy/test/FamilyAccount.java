package test;

public class FamilyAccount {

    public static void main(String[] args) {

        boolean isflag = true;
        String details = "收支\t账户金额\t收支金额\t说   明\n";

        int balance = 10000;


        while (isflag){

            System.out.println("--------------家庭收支软件------------------");
            System.out.println("--------------1.收支明细--------------------");
            System.out.println("--------------2.登记收入--------------------");
            System.out.println("--------------3.登记支出--------------------");
            System.out.println("--------------4.退   出--------------------");
            System.out.print("-------------请选择（1-4）：--------------------");


            //获取用户的选择
            char c = Utility.readMenuSelection();
            switch (c){
                case '1':
                   // System.out.println("收支明细");
                    System.out.println("=============当前收支收明细记录=============");


                    System.out.println(details);
                    System.out.println("=========================================");
                    break;
                case '2':
                    //System.out.println("登记收入");
                    System.out.print("本次收入金额：");
                    int money = Utility.readNumber();
                    System.out.print("本次收入说明：");
                    String info = Utility.readString();
                    //处理details

                    balance+=money;
                    details +="收入\t"+balance+"\t"+money+"\t"+info+"\n";

                    System.out.println("登记完成");
                    break;
                case '3':
                    //System.out.println("登记支出");

                    System.out.print("本次支出金额：");
                    int minmoney = Utility.readNumber();
                    System.out.print("本次支出说明：");
                    String mininfo = Utility.readString();
                    if (balance>=minmoney){
                        balance-=minmoney;
                        details +="支出\t"+balance+"\t"+minmoney+"\t"+mininfo+"\n";

                    }else {
                        System.out.println("支出超出账户额度，支付失败。");
                    }


                    System.out.println("登记完成");
                    break;
                case '4':
                    System.out.println("退出");
                    System.out.println("确认是否退出（Y/N）：");
                    char c1 = Utility.readConfirmSelection();
                    if (c1=='Y'){
                        isflag=false;
                    }

                    break;
            }

        }
    }
}
