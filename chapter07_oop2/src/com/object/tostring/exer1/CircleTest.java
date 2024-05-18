package com.object.tostring.exer1;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/22 下午 09:39
 * @Version 1.0
 */
public class CircleTest {

    public static void main(String[] args) {
        Circle c1 = new Circle();
        Circle c2 = new Circle("red",2.2,3.0);
        Circle c3 = new Circle(1.0);

        System.out.println(c1.getColor().equals(c2.getColor())); //比顏色是否相等

        System.out.println(c1.equals(c2)); //看equals()重寫後是比較甚麼 (規則自定義，何謂相等)

        System.out.println(c1);

        System.out.println(c1.equals(c3));
    }
}
