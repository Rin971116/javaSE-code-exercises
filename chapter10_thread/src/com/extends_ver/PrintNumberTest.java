package com.extends_ver;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/4/18 上午 01:16
 * @Version 1.0
 */
public class PrintNumberTest {

    public static void main(String[] args) {

        //方式1.
//        PrintEvenNumber t1 = new PrintEvenNumber();
//        PrintOddNumber t2 = new PrintOddNumber();
//
//        t1.start();
//        t2.start();


        //方式2. 建立Thread的匿名子類的匿名對象，順便調了start(()。
        new Thread(){
            @Override
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    if (i % 2 == 0){
                        System.out.println(Thread.currentThread().getName() + ": " + i);
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    if (i % 2 == 1){
                        System.out.println(Thread.currentThread().getName() + ": " + i);
                    }
                }
            }
        }.start();


    }
}

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





