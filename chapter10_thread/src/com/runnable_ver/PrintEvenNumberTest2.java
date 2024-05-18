package com.runnable_ver;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/4/18 下午 07:02
 * @Version 1.0
 */
public class PrintEvenNumberTest2 {
    public static void main(String[] args) {
        //方式1. 線程1 和 線程2 是透過單一對象e所建立的線程，故兩個線程在操作的屬性，即testNum是同一份。
        PrintEvenNumber e = new PrintEvenNumber();
        new Thread(e) {
        }.start(); //新線程1 啟動，並且調用對象的run()
        new Thread(e) {
        }.start(); //新線程2 啟動，並且調用對象的run()

        //main線程
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }

        //方式2. !!注意這樣 線程3 和 線程4 所建立的匿名Runnable實現類的對象，是兩個不同對象，因此testNum是各自一份。
        new Thread(new Runnable() { // 線程3.
            private int testNum = 100;
            @Override
            public void run() {
                for (int i = 1; i <= 100; i++) {

                    System.out.println(Thread.currentThread().getName() + ": (第" + i + "次)" + --testNum);

                }
            }
        }).start();

        new Thread(new Runnable() { // 線程4.
            private int testNum = 100;
            @Override
            public void run() {
                for (int i = 1; i <= 100; i++) {

                    System.out.println(Thread.currentThread().getName() + ": (第" + i + "次)" + --testNum);

                }
            }
        }).start();
    }
}

class PrintEvenNumber implements Runnable {
    private int testNum = 100;

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
//            if (i % 2 == 0){
//                System.out.println(Thread.currentThread().getName() + ": " + i);
//            }
            System.out.println(Thread.currentThread().getName() + ": (第" + i + "次)" + --testNum);
        }
    }

    public int getTestNum() {
        return testNum;
    }

    public void setTestNum(int testNum) {
        this.testNum = testNum;
    }
}
