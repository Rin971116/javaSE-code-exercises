package com.communication.ProducerConsumerExer;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/4/23 下午 07:53
 * @Version 1.0
 */
class Producer implements Runnable{
    private Product product;

    public Producer(Product product) {
        this.product = product;
    }

    /**
     * 生產貨物，囤貨最多不得超過 20個
     */
    @Override
    public void run() {

        while (true) {
            product.addAmount();
        }
    }

}


