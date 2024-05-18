package com.this_exer2;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/12 下午 07:59
 * @Version 1.0
 */
public class BankTest {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.addCustomer("Lin","Brian");
        bank.addCustomer("Lin","BABY");

        bank.getCustomer(1).setAccount(new Account(300000000));
        bank.getCustomer(1).getAccount().getBalance();
        bank.getCustomer(1).getAccount().withdraw(500);
        bank.getCustomer(1).getAccount().getBalance();
    }
}
