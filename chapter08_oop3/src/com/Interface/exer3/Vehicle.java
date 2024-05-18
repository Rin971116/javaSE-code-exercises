package com.Interface.exer3;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/4/1 下午 04:59
 * @Version 1.0
 */
public abstract class Vehicle {
    private String brand;
    private String color;

    public Vehicle() {
    }

    public Vehicle(String brand, String color) {
        this.brand = brand;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract void run();
}
