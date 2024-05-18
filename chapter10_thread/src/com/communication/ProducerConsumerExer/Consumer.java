package com.communication.ProducerConsumerExer;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/4/23 下午 07:55
 * @Version 1.0
 */
public class Consumer implements Runnable{

    private Product product;

    public Consumer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        while (true) {
            product.minusAmount();
        }
    }
}
