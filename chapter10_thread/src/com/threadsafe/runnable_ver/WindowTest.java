package com.threadsafe.runnable_ver;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/4/22 下午 03:01
 * @Version 1.0
 */
class SaleTicket implements Runnable{

    private int totalTicket = 100;

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

            synchronized (this){ //型參可以輸入任何類的對象，但必須是唯一對象，這邊調this 等於當前調用run()的對象。
                if (totalTicket > 0){
                    System.out.println(Thread.currentThread().getName() + " ，票號:" + totalTicket--);
                }
            }

        }
    }
}

public class WindowTest {
    public static void main(String[] args) {
        SaleTicket s = new SaleTicket();

        Thread t1 = new Thread(s,"窗口1");
        Thread t2 = new Thread(s);
        Thread t3 = new Thread(s);

        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
