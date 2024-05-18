package com.Interface.newInterface;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/4/2 上午 12:25
 * @Version 1.0
 */
public class SubClassTest {

    public static void main(String[] args) {
        SubClass sub = new SubClass();
        sub.method1(); //"這是SuperClass的方法1"，優先順序為: (子類 > 父類 > 實現之接口)
        sub.method2();
        System.out.println("--------------------");

        sub.method3();

        CompareB cb = new CompareB() { //匿名實現類的有名對象，此匿名類只能被調用目前這一次，但cb存取的對象可以多次調用。
            @Override
            public void method1() {
                System.out.println("匿名實現類臨時重寫的method1()");
            }

            @Override
            public void method2() {
                CompareB.super.method2();
            }

            @Override
            public void method3() {
                CompareB.super.method3();
            }
        };
        cb.method2();
        cb.method1();
        CompareB.method5(); //接口中聲明的靜態方法，透過接口名去調用。

        CompareB comparebb = new CompareB(){
            @Override
            public void method1(){
                System.out.println("這是建立匿名實現類時 臨時重寫的方法1");
            }
        };
        comparebb.method1();
        comparebb.method2();
        comparebb.method3();
        CompareB.method5();
    }

}
