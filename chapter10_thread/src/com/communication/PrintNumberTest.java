package com.communication;

/**
 * ClassName:
 * Description:
 *              確保 線程 1.和 線程 2.是交互輪流執行(線程 1.執行一次，線程 2.執行一次)
 *              使用 Object類中所定義的方法:
 *              (下述 4種方法只能使用在 同步代碼塊 or 同步方法 中)
 *                                        1. wait(): 在執行到 wait時 該線程原地等待，並釋放同步監視器(鎖)。
 *                                        2. wait(int time)
 *                                        3. notify(): 喚醒優先級最高的 一個線程。(優先級相同時，則隨機一個)
 *                                        4. notifyAll()
 * @Author Rin
 * @Create 2024/4/23 下午 06:42
 * @Version 1.0
 */
class PrintNumber implements Runnable{

    private int number = 0;

    @Override
    public void run() {
        while (true) {

            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //沒有得到鎖的線程在此等待。
            synchronized (this) {
                // 得到鎖後，進入第一件事，先喚醒在wait()行 等待的線程。
                notify();
                if (number < 100) {
                    number++;
                    System.out.println(Thread.currentThread().getName() + " :" + number);

                    try {
                        wait(); //暫停於此，並釋放鎖。
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } else {
                    break;
                }
            }
        }
    }
}

public class PrintNumberTest {
    public static void main(String[] args) {
        PrintNumber p = new PrintNumber();

        Thread t1 = new Thread(p,"線程1");
        Thread t2 = new Thread(p,"線程2");

        t1.start();
        t2.start();
    }
}
