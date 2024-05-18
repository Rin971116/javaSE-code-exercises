package com.polymorphism.exer2;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/21 上午 01:26
 * @Version 1.0
 */
public class PersonTest {

    public static void main(String[] args) {

        PersonTest test = new PersonTest();
        test.meeting(new Man(), new Woman());
    }

    public void meeting(Person... ps){ //相當於自動建立匿名Person[]

        for (int i = 0; i < ps.length; i++) {
            ps[i].eat(); //因為所有Person類及其子類 都有定義此方法，所以對於編譯器來說都找的到對應的方法
            ps[i].toilet();

            if (ps[i] instanceof Man){
                //ps[i].smoking(); 編譯不通過，因為編譯器認為 ps宣告為Person類，然而Person類中並沒有smoking()方法
                Man m = (Man)ps[i];
                m.smoking();
                //( (Man)ps[i] ).smoking(); 也可以

            }else if (ps[i] instanceof Woman){
                Woman w = (Woman)ps[i];
                w.makeUp();
                //((Woman)ps[i]).makeUp(); 也可以

            }
            //編譯通過，但凡是Person的子/父類，都是可以通過的
            //if (ps[i] instanceof Object){}

            //編譯不通過，不可能有關係，所以編譯不通過
            //if (ps[i] instanceof String){}
        }
    }
}
