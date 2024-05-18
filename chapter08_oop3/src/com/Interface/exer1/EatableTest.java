package com.Interface.exer1;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/4/1 下午 03:19
 * @Version 1.0
 */
public class EatableTest {
    public static void main(String[] args) {

        //注意!我們new數組時是寫new Eatable[3]; 而不是new Eatable[3](); ，這表示我們並不是new一個名為Eatable[]的類。
        Eatable[] eatables = new Eatable[3];
        eatables[0] = new Taiwanese();
        eatables[1] = new American();
        eatables[2] = new Indian();

        for (int i = 0; i < eatables.length; i++) {
            eatables[i].eat();
        }
    }
}
