package com.threadsafe.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ClassName:
 * Description:
 * 語法:
 * 1. 先建立一個 Reentrantlock 的唯一對象，Lock是一個 interface，Reentrantlock為 Lock的實現類。
 * 2. 對象名.lock(); //獲得鎖
 * ...
 * ...
 * ... 須同步的代碼
 * 對象名.unlock(); //釋放鎖
 *
 * @Author Rin
 * @Create 2024/4/23 下午 04:22
 * @Version 1.0
 */
class Window extends Thread {
    static int ticket = 100;

    private static boolean isFlag = true;

    //創建LOCK 實例，若使用extends的方式建立線程，則LOCK 需要聲明為static，成為唯一鎖。
    private static final ReentrantLock LOCK = new ReentrantLock();

    public Window(String name) {
        super(name);
    }

    @Override
    public void run() {

        while (isFlag) {

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            LOCK.lock();//獲取鎖，沒獲取鎖的線程，在此行等待鎖釋放。


            if (isFlag) { // 使發現ticket < 0 後的線程不必再進入if 執行以下語句。(避免多個線程進去都打印 sold out!)

                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + " :" + ticket--);
                } else {
                    isFlag = false;
                    System.out.println(Thread.currentThread().getName() + " :sold out!");

                }
            }

            LOCK.unlock();//必須手動釋放鎖
        }

    }
}

public class WindowTest {
    public static void main(String[] args) {
        Window w1 = new Window("線程1");
        Window w2 = new Window("線程2");
        Window w3 = new Window("線程3");

        w1.start();
        w2.start();
        w3.start();
    }
}




