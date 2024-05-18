package com.abstract_class;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/28 上午 12:45
 * @Version 1.0
 */
public class AbstractTest {

    public static void main(String[] args) {
//        Person p1 = new Person();
//        p1.eat();

        Student s1 = new Student();
        s1.eat();
        s1.sleep();

        Worker worker = new Worker() {
            @Override
            public void breath() {
                System.out.println("工人也會呼吸");
            }
        };

        worker.breath();
        worker.sleep();
        worker.eat();


        Creature creature = new Creature(){ //抽象類只要臨時重寫也能造對象。
            @Override
            public void breath(){
                System.out.println("生物會呼吸");
            };
        };

        creature.breath();
        Creature.method1(); //透過類去調用static方法
        creature.method3();

    }
}
