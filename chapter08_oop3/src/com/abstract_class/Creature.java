package com.abstract_class;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/28 上午 01:09
 * @Version 1.0
 */
public abstract class Creature {

    public abstract void breath();
    public static void method1(){
        System.out.println("這是抽象類中的靜態方法");
    }

    private void method2(){
        System.out.println("這是抽象類中的私有方法");
    }

    public void method3(){
        method2();
    }
}
