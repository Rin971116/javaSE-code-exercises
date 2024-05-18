package com.threadsafe.extends_ver;

/**
 * ClassName:
 * Description:
 *              使用 同步代碼塊 synchronized(){}，處理線程安全，主要作用為在 任一線程走完synchronized(){}中的執行語句之前
 *              ，其他線程不得進入 synchronized(){}。
 *
 *              格式:     synchronized(任意類的唯一對象){
 *                          操作共享數據的執行語句
 *                      }
 * @Author Rin
 * @Create 2024/4/22 下午 03:01
 * @Version 1.0
 */
class Window extends Thread{

    private static int totalTicket = 100;

    @Override
    public void run() {
        while (true){

            try {
                //為防止單一線程連續搶，意思是 任何線程 你進了while(true)後第一件事事先睡5毫秒
                // ，這樣可以保證搶過的線程，再次進入while(true)迴圈時，必須先睡一下，在他睡的這段時間
                // ，其他的線程因為已經睡過了早就在等了，這時就優先進去了。
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 這邊使用(類名.class)，實際上是代表類的一個對象，即 Class c = Window.class ，前面的Class是有一個類，他的名字叫Class。
            // 這邊如過用this的話 等於各自調用run()的對象，即 t1,t2,t3。(不滿足唯一性)
            synchronized (Window.class){
                if (totalTicket > 0){
                    System.out.println(Thread.currentThread().getName() + " ，票號:" + totalTicket--);
                }
            }

        }
    }
}

public class WindowTest {
    public static void main(String[] args) {

        Window t1 = new Window();
        Window t2 = new Window();
        Window t3 = new Window();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
