package com.threadsafe.safesingleton;

/**
 * ClassName:
 * Description:
 *                  //單例模式: 線程安全的懶漢式
 * @Author Rin
 * @Create 2024/4/25 下午 08:15
 * @Version 1.0
 */

class Singleton {
    private static Singleton s1;
    private static final Object OBJ = new Object();

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (s1 == null) {
            synchronized (OBJ) {
                if (s1 == null) {
                    s1 = new Singleton();
                }
            }
        }
        return s1;
    }
}
