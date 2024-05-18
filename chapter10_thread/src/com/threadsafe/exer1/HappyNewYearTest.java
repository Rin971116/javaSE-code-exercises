package com.threadsafe.exer1;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/4/22 下午 10:34
 * @Version 1.0
 */
class HappyNewYear implements Runnable{
    private int num = 10;
    @Override
    public void run() {
        while(true){

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (num > 0){
                System.out.println(num--);
            }else {
                System.out.println("新年快樂!!");
                break;
            }
        }
    }
}

public class HappyNewYearTest {
    public static void main(String[] args) {
        HappyNewYear h = new HappyNewYear();

        Thread t1 = new Thread(h,"線程1");

        t1.start();
    }
}
