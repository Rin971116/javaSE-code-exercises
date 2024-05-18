package com.communication.ProducerConsumerExer;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/4/23 下午 07:47
 * @Version 1.0
 */

public class ProducerConsumeryTest {
    public static void main(String[] args) {
        Product p = new Product();
        Producer producer = new Producer(p);
        Consumer consumer = new Consumer(p);

        Thread t1 = new Thread(producer,"生產者1");
        Thread t2 = new Thread(consumer,"消費者1");

        t1.start();
        t2.start();
    }
}
