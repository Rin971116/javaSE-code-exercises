package com.Interface.exer3;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/4/1 下午 04:56
 * @Version 1.0
 */
public class Developer {
    private String name;
    private int age;

    public Developer() {
    }

    public Developer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 開發者的交通方式
     * @param vehicle 交通工具
     */
    public void takingVehicle(Vehicle vehicle){
        vehicle.run();
    }
}
