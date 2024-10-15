package com.communication.ProducerConsumerExer;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/4/23 下午 07:54
 * @Version 1.0
 */

public class Product {
    private int amount;
    private Object obj = new Object();

    /**
     * 操作共享數據的方法，包成 synchronized方法 或 使用synchronized代碼塊包起來。
     */
    public void addAmount(){

        synchronized (obj) {
            if (amount >= 20){
                try {
                    obj.wait(); //定義:讓執行到此語句的線程暫停，並釋放鎖(這邊指obj)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                amount++;
                System.out.println(Thread.currentThread().getName() + "補了一份，剩餘:" + amount + "份");
                obj.notifyAll();
            }
        }
    }

    public void minusAmount(){

//        try {
//            Thread.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        synchronized (obj) { //保證同時刻只能有一個線程進入，此案例代表同時刻只能有一個線程購買，其他的線程需在此等待獲得同步監視器才能進入。
            if (amount <= 0){
                try {
                    obj.wait(); //定義:讓直行到此語句的線程暫停，並釋放鎖(這邊指obj)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                amount--;
                System.out.println(Thread.currentThread().getName() + "買了一份，剩餘:" + amount + "份");
                obj.notify();
            }
        }
    }

}
