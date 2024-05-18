package com.oop2;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/6 下午 04:27
 * @Version 1.0
 */
public class Circle {
    int x,y;
    double r;
    double area;
    public Circle(int x, int y, double r){
        this.x = x;
        this.y = y;
        this.r = r;
        area = r * r * 3.14;
    }

    public void changeR(double newR){
        this.r = newR;
        area = newR * newR * 3.14;
    }
    public double getArea(){
        return area;
    }
}
