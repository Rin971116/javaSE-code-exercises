package com.Interface.exer3;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/4/1 下午 05:02
 * @Version 1.0
 */
public class Car extends Vehicle implements IPower{
    public Car() {
    }

    public Car(String brand, String color) {
        super(brand, color);
    }

    @Override
    public void run() {
        System.out.println("開汽車");
    }

    @Override
    public void power() {
        System.out.println("汽車使用汽油");
    }
}
