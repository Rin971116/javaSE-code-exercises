package com.abstract_class;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/28 上午 12:44
 * @Version 1.0
 */
public class Student extends Person{
    @Override
    public void eat(){
        System.out.println("學生吃多點");
    }

    @Override
    public void sleep() {
        System.out.println("學生多睡一點");
        /*
                如果抽象父類中，有聲明抽象方法的話，那子類必須override該方法
                ，否則編譯不通過，編譯認為Student類也有一份為重寫的抽象方法，因此Student類必須是一個抽象方法
                所以要馬Student類也是抽象類，要馬override抽象父類中的抽象方法
        */
    }

    @Override
    public void breath() {
        System.out.println("學生應該多呼吸新鮮空氣");
    }
}
