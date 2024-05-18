package com.this_exer1;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/12 下午 05:27
 * @Version 1.0
 */
public class BoyGirlTest {
    public static void main(String[] args) {

        Boy boy1 = new Boy("傑克",24);
        Girl girl1 = new Girl("瑪莉",18);

        boy1.marry(girl1);

        girl1.marry(boy1);

        boy1.shout();

        Girl girl2 = new Girl("陽菜",26);

        int compare = girl1.compare(girl2);
        if(compare > 0){
            System.out.println(girl1.getName()+"大");
        }else if (compare < 0){
            System.out.println(girl2.getName()+"大");
        }else {
            System.out.println(girl1.getName()+"和"+girl2.getName()+"一樣大");
        }
    }
}
