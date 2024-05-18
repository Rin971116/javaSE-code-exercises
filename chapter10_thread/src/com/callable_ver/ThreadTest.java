package com.callable_ver;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * ClassName:
 * Description:
 *                  建立線程的方式 3:
 *                                  1. 建立 Callable的實現類，並重寫 call()，等於其他建立線程方式中的 run()。
 *                                  2. 在 main線程中 new Callable的實現類對象，CallableTest c = new CallableTest();
 *                                  3. FutureTask f = new FutureTask(c);，(FutureTask是 Runnable的實現類)
 *                                  4. Thread t1 = new Thread(f);
 *
 *                                  實現Callable的好處(較靈活):
 *                                      1. Callable中定義的 call()，可以向上拋出 Exception層級的異常。
 *                                      2. call()可以返回一個 Object對象，使用 FutureTask的對象.get()。
 *
 * @Author Rin
 * @Create 2024/4/25 下午 06:35
 * @Version 1.0
 */
class CallableTest implements Callable {
    @Override
    public Object call() throws Exception {
        return null;
    }
}

public class ThreadTest {
    public static void main(String[] args) {

        CallableTest c = new CallableTest();
        FutureTask f = new FutureTask(c);
        Thread t1 = new Thread(f);

        t1.start();
    }
}
