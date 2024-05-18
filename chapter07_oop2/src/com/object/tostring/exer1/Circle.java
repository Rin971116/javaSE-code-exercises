package com.object.tostring.exer1;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/22 下午 09:27
 * @Version 1.0
 */
public class Circle extends GeometricObject{

    private double radius;

    public Circle() {
        radius = 1.0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

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

    /**
     * 計算面積
     * @return 面積
     */
    public double findArea(){
        return radius * radius * 3.14;
    }

    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if (obj instanceof Circle){
            Circle c = (Circle) obj;
            return this.radius == c.radius && getColor().equals(c.getColor());
        }
        else return false;
    }

    public String toString(){
        return "Circle{ radius =" + radius + "}";
    }
}
