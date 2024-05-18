package com.oop1;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/6 下午 04:14
 * @Version 1.0
 */
public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.study();
        System.out.println("現在"+p1.showAge()+"歲");
        p1.addAge(5);
        System.out.println("現在"+p1.showAge()+"歲");
    }
}
