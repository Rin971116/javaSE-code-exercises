package com.Interface.exer2;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/4/1 下午 03:49
 * @Version 1.0
 */
public class Circle implements CompareObject{
    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }

    @Override
    public int compareTo(Object o){
        if (o instanceof CompareCircle) {
            CompareCircle c = (CompareCircle) o;
            //方法1.
//            if (this.getRadius() > c.getRadius()) {
//                return 1;
//            } else if (this.getRadius() == c.getRadius()) {
//                return 0;
//            } else if (this.getRadius() < c.getRadius()) {
//                return -1;
//            }

            //方法2.
            return Double.compare(this.getRadius(),c.getRadius());
        }else {
            return 2; //暫且無解
//            throw new RuntimeException("輸入類型錯誤",new Throwable("輸入錯誤"));
        }
    }
}
