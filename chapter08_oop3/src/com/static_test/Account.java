package com.static_test;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/24 下午 01:53
 * @Version 1.0
 */
public class Account {

    private int id = init;

    private String password;
    private int balance = 1000;
    private static double interestRate;
    private static double minBalance;
    private static int init = 1001;

    public Account() {
        //由此可證，new對象時，是先建立屬性、方法，才執行constrcter內的敘述。
//        System.out.println("balance:" + balance);
//        System.out.println("init:" + init);
//        System.out.println("id:" + id);
        init++;
    }

    public Account(String password, int balance) {
        this.password = password;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }
}
