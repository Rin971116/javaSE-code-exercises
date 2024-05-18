package com.Interface;

/**
 * ClassName:
 * Description:
 *
 *              !!接口與抽象類最大的不同在於，接口除了全局常量(public static final)以外，不能聲明其他屬性
 *              格式: class A extends SuperA implements B,C{}
 *
 *              A 對於 SuperA 來說，叫做子類
 *              A 對於 B,C 來說，叫做實現類
 *
 *              滿足此關係，說明:
 *              > 類可以實現多個接口
 *              >類針對於接口的多實現，一定程度上彌補了類的 單繼承 的侷限性
 *              >類必須將實現的接口中的所有的抽象方法都 override(或實現)，方可實例化。否則，此實現類必須聲明為抽象類。
 *
 * @Author Rin
 * @Create 2024/3/29 下午 06:52
 * @Version 1.0
 */
public class InterfaceTest {

    public static void main(String[] args) {
        System.out.println(Flyable.MIN_SPEED);
        System.out.println(Flyable.MAX_SPEED);

//        Flyable.MAX_SPEED = 7900; 報錯，接口的屬性為final，不能被更改;

        Bullet b = new Bullet();
        b.fly();
        b.attack();
        b.move();
    }
}

interface Flyable{
    //接口的屬性必須是public ,static ,final; 同時不存在constructor ,block，所以屬性初值必須直接附上;
    //全局常量
    public static final int MIN_SPEED = 0;

    //可以省略public static final
    int MAX_SPEED = 8000;

    //接口方法必須是抽象方法 public abstract，且沒有方法體
    public abstract void fly();

    //可以省略public abstract
    void move();
}

interface Attackable{

    void attack();
}

class Bullet implements Flyable,Attackable{

    @Override
    public void fly() {
        System.out.println("子彈會飛");
    }

    @Override
    public void move() {
        System.out.println("子彈會移動");
    }

    @Override
    public void attack() {
        System.out.println("子彈可以攻擊");
    }
}