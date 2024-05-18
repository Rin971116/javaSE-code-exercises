package com.Interface.exer3;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/4/1 下午 05:04
 * @Version 1.0
 */
public class ElectricVehicle extends Vehicle implements IPower{

    public ElectricVehicle() {
    }

    public ElectricVehicle(String brand, String color) {
        super(brand, color);
    }

    @Override
    public void run() {
        System.out.println("開電車");
    }
    @Override
    public void power(){
        System.out.println("電車使用電力");
    }
}
