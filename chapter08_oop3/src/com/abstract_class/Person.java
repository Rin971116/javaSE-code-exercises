package com.abstract_class;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/28 上午 12:42
 * @Version 1.0
 */
public abstract class Person extends Creature{
//聲明成抽象類，代表著此類不能造對象了，但注意!!不代表不能造其子類。
    private String name;
    private int age;

    public void eat(){ //非抽象方法，默認方法
        System.out.println("人吃飯");
    }

    public abstract void sleep(); //抽象方法，不能有{}
}
