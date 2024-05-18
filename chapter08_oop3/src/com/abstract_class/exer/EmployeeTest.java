package com.abstract_class.exer;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/28 上午 02:07
 * @Version 1.0
 */
public class EmployeeTest {

    public static void main(String[] args) {
        SalariedEmployee employee1 = new SalariedEmployee("Rin",1,
                new MyDate(2000,6,28),10000);

        System.out.println(employee1.toString());
        System.out.println("薪資:" + employee1.earnings());

        HourlyEmployee employee2 = new HourlyEmployee("pt-Rin",1,
                new MyDate(2000,6,28),150,8);

        System.out.println(employee2.toString());
        System.out.println("薪資:" + employee2.earnings());
    }
}
