package com.enum_class.exer2;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/4/6 下午 02:33
 * @Version 1.0
 */
public class ColorTest {
    public static void main(String[] args) {
        //enum類 private構造器，不可由外造對象
        System.out.println(Color.RED);
        System.out.println("-----------------------");

        Color[] colors = Color.values();
        for (int i = 0; i < colors.length; i++) {
            System.out.println(colors[i]);
        }
    }
}
