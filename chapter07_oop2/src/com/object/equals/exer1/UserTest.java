package com.object.equals.exer1;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/22 下午 01:41
 * @Version 1.0
 */
public class UserTest {

    public static void main(String[] args) {
        User u1 = new User("1",10);
        User u2 = new User("1",10);

        System.out.println(u1.equals(u2));

    }
}
