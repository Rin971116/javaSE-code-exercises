package com.singleton;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/26 上午 12:17
 * @Version 1.0
 */
public class SingletonTest {

    public static void main(String[] args) {
        Singleton instance = Singleton.getSingleton();
        //然後就可透過instance去使用Singleton類內中的方法
    }
}
