package com.oop2;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/6 下午 04:33
 * @Version 1.0
 */
public class CircleTest {
    public static void main(String[] args) {
        Circle c1 = new Circle(0,0,10.5);
        System.out.println("area:"+c1.getArea());
        c1.changeR(15.2);
        System.out.println("area:"+c1.getArea());
    }
}
