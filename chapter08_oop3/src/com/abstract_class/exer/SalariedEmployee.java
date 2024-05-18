package com.abstract_class.exer;

/**
 * ClassName:
 * Description:     月薪員工類
 *
 * @Author Rin
 * @Create 2024/3/28 上午 01:56
 * @Version 1.0
 */
public class SalariedEmployee extends Employee{

    private double monthlySalary;

    public SalariedEmployee() {
    }

    public SalariedEmployee(String name, int number, MyDate birthday, double monthlySalary) {
        super(name, number, birthday);
        this.monthlySalary = monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double earnings() {
        return monthlySalary;
    }

    @Override
    public String toString() {
        return "SalariedEmployee{" + super.toString() + "}";
    }
}
