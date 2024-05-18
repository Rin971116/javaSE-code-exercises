package com.polymorphism;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/4/9 下午 11:43
 * @Version 1.0
 */
public class PolymorphismTest {
    public static void main(String[] args) {
        Person p1 = new Student();
        System.out.println(p1.i); //10 (屬性就近找)(直接從變數宣告的型別下去找)
        p1.method1(); //student p1實際所指對象找
        p1.method2(); //person static (直接從變數宣告的型別下去找)，但正常情況也不會用對象去調用static方法。

        Person p2 = null;
        p2.method2(); //person static 由此可證，他壓根不管對象是誰。
    }
}

class Person{
    int i = 10;
    public void method1(){
        System.out.println("person");
    }

    public static void method2(){
        System.out.println("person static");
    }
}

class Student extends Person{
    int i = 100;
    @Override
    public void method1(){
        System.out.println("student");
    }

    public static void method2(){
        System.out.println("person static");
    }
}