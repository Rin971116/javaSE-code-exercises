package com.Interface.newInterface;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/4/2 上午 12:24
 * @Version 1.0
 */
public interface CompareB extends CompareA{

//    void method1(); 繼承拿到了一份，多一個規範。
    public default void method2(){ //jdk新特性，接口內可以聲明默認方法。(要加default是因為在接口內甚麼都不加的話會默認成abstract)
        System.out.println("這是CompareB的方法2");
    }

    public default void method3(){
        System.out.println("這是CompareB的方法3" + "\t" + method4());
    }

    private int method4(){ // jdk9的新特性，接口中可以聲明私有方法，供接口中其他默認方法自己使用。
        return 123;
    }

    public static void method5(){
        System.out.println("這是CompareB的靜態方法5");
    }
}
