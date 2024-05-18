package com.polymorphism.exer1;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/21 上午 12:23
 * @Version 1.0
 */
public class Circle extends GeometricObject{

    private double radius;
    public Circle(String color, double weight, double radius) {
        super(color, weight);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    @Override
    public double findArea(){
        return radius * radius * 3.14;
    }
}

