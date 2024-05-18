package com.inheritance;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/20 下午 06:46
 * @Version 1.0
 */
public class AccountTest {
    public static void main(String[] args) {

        Account a1 = new Account(1122,20000,0.045);
        a1.withdraw(30000);
        System.out.println("balance:" + a1.getBalance());

        a1.withdraw(2500);
        a1.depoist(3000);
        System.out.println("balance:" + a1.getBalance());
        System.out.println("Monthly Interest Rate:" + a1.getMonthlyInterest());
    }
}
