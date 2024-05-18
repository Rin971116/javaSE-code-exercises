package com.inheritance;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/20 下午 06:53
 * @Version 1.0
 */
public class CheckAccount extends Account{

    private double overdraft; //可透支的金額
    public CheckAccount(int id, double balance, double annualInterestRate) {
        super(id, balance, annualInterestRate);
    }

    public CheckAccount(int id, double balance, double annualInterestRate, double overdraft) {
        super(id, balance, annualInterestRate);
        this.overdraft = overdraft;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }
@Override
    public void withdraw(double amount) {
        if (amount >= 0) {
            if (getBalance() >= amount) {
                //setBalance(getBalance() - amount);
                super.withdraw(amount);

            } else if (getBalance() + overdraft >= amount) {
                overdraft += (getBalance() - amount);
                super.withdraw(getBalance()); //將balance變為0，這是在如果沒有setBalance()的情況下(正常情況都是這樣)
                //setBalance(0);

            }else {
                System.out.println("超過 帳戶餘額+本月透支額度!!");
                System.out.println();
            };
        }else System.out.println("提款金額不得小於0!!");
    }

    public void show(double balance, double overdraft){
        System.out.println("您的帳戶餘額:" + balance);
        System.out.println("您本月可透支額度:" + overdraft);
        System.out.println();
    }
}
