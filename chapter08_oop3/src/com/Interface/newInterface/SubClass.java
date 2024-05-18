package com.Interface.newInterface;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/4/2 上午 12:23
 * @Version 1.0
 */
public class SubClass extends SuperClass implements CompareA,CompareB{

//    @Override
//    public void method1() {
//        System.out.println("這是SubClass重寫的方法1");
//    }

    // 由上例可見，從父類繼承的method1()被視為實現了接口CompareA的method1()需求。故子類中不用再重寫method1()。


    @Override // 由此可見方法覆蓋的優先度 (子類 > 父類 > 接口)
    public void method2() {
        System.out.println("這是SubClass重寫的方法2");
        CompareB.super.method2();
        CompareB.super.method3();
    }

    public static void method6(){
        System.out.println("這是靜態方法6");
    }

    public static void main(String[] args) {
//        SubClass subClass = new SubClass();
        SubClass.method6();
    }
}
