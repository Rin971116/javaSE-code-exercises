package com.extends_ver;

/**
 * ClassName:
 * Description:
 *                  建立線程的方式 1:
 *                              前置作業:
 *                                  1.創建一個類 並 extends Thread
 *                                  2.重寫 run()，並將需要此線程進行的操作 寫在方法體中
 *
 *                              再來實際建立線程:
 *                                  1.在 main線程中，new 該類的物件
 *                                  2.透過該物件 調用 start()，即可開啟該線程，一個實例對象 對應一個 線程
 * @Author Rin
 * @Create 2024/4/18 上午 01:16
 * @Version 1.0
 */
public class ThreadTest extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 1) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

class PrintNumberTest {

    public static void main(String[] args) {

        //方式1.
//        PrintEvenNumber t1 = new PrintEvenNumber();
//        PrintOddNumber t2 = new PrintOddNumber();
//
//        t1.start();
//        t2.start();


        //方式2. 建立Thread的匿名子類的匿名對象，順便調了start(()。
        new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + ": " + i);
                    }
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    if (i % 2 == 1) {
                        System.out.println(Thread.currentThread().getName() + ": " + i);
                    }
                }
            }
        }.start();


    }

}





