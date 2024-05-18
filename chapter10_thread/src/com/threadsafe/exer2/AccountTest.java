package com.threadsafe.exer2;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/4/22 下午 10:53
 * @Version 1.0
 */
class Customer extends Thread{
    private Account account;

    public Customer(Account account) {
        this.account = account;
    }

    @Override
    public void run() {


        for (int i = 0; i < 3; i++) {

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            account.deposit(1000);
        }
    }

}

class Account{
    private int balance;

    public synchronized void deposit(int amount){ //默認鎖為this，此時this所指對象為a1，是唯一對象，可以使用，
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " :" + balance);
    }

}

public class AccountTest {
    public static void main(String[] args) {
        Account a1 = new Account();

        Customer t1 = new Customer(a1);
        Customer t2 = new Customer(a1);

        t1.setName("線程1(用戶1)");
        t2.setName("線程2(用戶2)");

        t1.start();
        t2.start();
    }
}
