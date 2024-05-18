package com.inheritance;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/20 下午 06:36
 * @Version 1.0
 */
public class Account {
    private int id;
    private double balance;
    private double annualInterestRate; //年利率


    public Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public double getMonthlyInterest(){
        return annualInterestRate/12; //月利率 = 年利率/12個月
    }

    /**
     * 提款取錢
     * @param amount 欲取出的金額
     */
    public void withdraw(double amount){
        if(balance >= amount && amount > 0){
            balance -= amount;
        }else System.out.println("帳戶餘額不足!!");
    }

    /**
     * 存錢
     * @param amount 欲存入的金額
     */
    public void depoist(double amount){
        if(amount > 0){
            balance += amount;
        }else System.out.println("金額不得小於0");
    }
}
