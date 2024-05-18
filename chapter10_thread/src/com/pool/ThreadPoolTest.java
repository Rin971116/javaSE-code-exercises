package com.pool;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/4/25 下午 07:10
 * @Version 1.0
 */
class PrintOddNumber extends Thread{
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 1){
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

class PrintEvenNumber extends Thread{ // 1.創建一個Thread的子類(繼承於Thread類)。

    // 2.重寫Thread類中的 run()
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

public class ThreadPoolTest {
    public static void main(String[] args) {

    }
}
