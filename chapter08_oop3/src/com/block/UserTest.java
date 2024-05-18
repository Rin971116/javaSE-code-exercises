package com.block;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/26 下午 07:02
 * @Version 1.0
 */
public class UserTest {
    public static void main(String[] args) {
        User u1 = new User();
        User u2 = new User("rin","123123");

        System.out.println(u1.getInfo());
        System.out.println(u2.getInfo());

        UserBlockVer u3 = new UserBlockVer();

        System.out.println(u3.getInfo());
    }
}
