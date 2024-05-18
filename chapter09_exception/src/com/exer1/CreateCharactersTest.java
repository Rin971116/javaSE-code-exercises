package com.exer1;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/4/15 下午 06:30
 * @Version 1.0
 */
public class CreateCharactersTest {
    public static void main(String[] args) {

        Characters c1 = new Characters("Rin",100);
        System.out.println(c1.toString());

        Characters c2 = new Characters("Tony",-1); //報NolifeValueException，其以下代碼皆不會執行。
        System.out.println(c2.toString());

        Characters c3 = new Characters("Tony",50);
        System.out.println(c3.toString());
    }
}
