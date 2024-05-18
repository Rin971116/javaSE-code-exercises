package com.oop1;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/6 下午 04:10
 * @Version 1.0
 */
public class Person {
    String name;
    int age;
    char gender;

    public void study(){
        System.out.println("studying");
    }

    public int showAge(){
        return age;
    }

    public void addAge(int addAge){
        age += addAge;
    }
}
