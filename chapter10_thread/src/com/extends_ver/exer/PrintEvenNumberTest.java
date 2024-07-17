package com.extends_ver;

/**
 * ClassName:
 * Description:
 *              例題: 創建一個分線程 1，用於遍歷 100以內的偶數。
 *              1.創建一個Thread的子類(繼承於Thread類)。
 *              2.重寫Thread類中的 run()
 *              3.創建當前Thread子類的對象
 *              4.啟動線程，並且調用該線程的run()，注意!!不能讓已經 start()的線程再 start()。
 * @Author Rin
 * @Create 2024/4/18 上午 12:39
 * @Version 1.0
 */
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

public class PrintEvenNumberTest {
    public static void main(String[] args) {
        // 3.創建當前Thread子類的對象
        PrintEvenNumber t1 = new PrintEvenNumber();
        t1.start(); // 4.啟動線程，並且調用該線程的run()

        PrintEvenNumber t2 = new PrintEvenNumber(); //再創立一個新線程，目前共有p1、p2、main線程，三個線程
        t2.start(); // 一樣新線程需要啟動

        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}


