package com.this_exer1;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/12 下午 05:06
 * @Version 1.0
 */
public class Boy {
    private String name;
    private int age;
    private char gender;

    public Boy() {
        this.gender = '男';
    }

    public Boy(String name, int age) {
        this();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void marry(Girl girl){
        System.out.println("我想娶"+girl.getName());
    }

    public void shout(){
        if (this.age > 20){
            System.out.println("我終於可以結婚了!");
        }else {
            System.out.println("不~我還未滿18歲");
        }
    }
}
