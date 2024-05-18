package com.this_exer2;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/12 下午 05:45
 * @Version 1.0
 */
public class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    /**
     * 存錢
     * @param amt 欲存入的金額
     */
    public void deposit(double amt) {
        if(amt > 0){
            balance += amt;
            System.out.println("deposit sucess , balance: "+balance);
        }else {
            System.out.println("deposit fail");
        }
    }

    /**
     * 提款
     * @param amt 欲取入的金額
     */
    public void withdraw(double amt) {
        if (amt <= balance){
            balance -= amt;
            System.out.println("withdraw sucess , balance: "+balance);
        }else{
            System.out.println("withdraw fail , amt > balance");
        }
    }


}
