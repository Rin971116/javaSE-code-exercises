package com.abstract_class.exer;

/**
 * ClassName:
 * Description:     時薪員工類
 *
 * @Author Rin
 * @Create 2024/3/28 上午 02:05
 * @Version 1.0
 */
public class HourlyEmployee extends Employee{

    private double wage;
    private int hour;

    public HourlyEmployee() {
    }

    public HourlyEmployee(String name, int number, MyDate birthday, double wage, int hour) {
        super(name, number, birthday);
        this.wage = wage;
        this.hour = hour;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    @Override
    public double earnings() {
        return wage * hour;
    }

    @Override
    public String toString() {
        return "HourlyEmployee{" + super.toString() + ",\twage:" + wage + ",\thour:" + hour + "}";
    }
}
