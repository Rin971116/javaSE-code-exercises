package com.abstract_class.exer;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/28 上午 02:18
 * @Version 1.0
 */
public class PayrollSystem {

    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<Employee>();
//        System.out.println(employees.size()); 取得數組長度，等於.length的效果
        employees.add(new SalariedEmployee("Rin",1,
                new MyDate(2000,6,28),10000));

        employees.add(new HourlyEmployee("pt-Rin",1,
                new MyDate(2000,6,28),150,8));

        employees.add(new SalariedEmployee("Rin2",1,
                new MyDate(2000,6,28),10000));

        employees.add(new SalariedEmployee("Rin3",1,
                new MyDate(2000,6,28),10000));

        employees.add(new SalariedEmployee("Rin4",1,
                new MyDate(2000,6,28),10000));

        employees.add(new SalariedEmployee("Rin5",1,
                new MyDate(2000,6,28),10000));

        Scanner sc = new Scanner(System.in);
        System.out.print("請輸入本月月份:");
        int theMonth = sc.nextInt();

        for (int i = 0; i < employees.size(); i++) {
            System.out.print(i+1 + "\t");
            System.out.println(employees.get(i).toString());
            System.out.println("月薪:" + employees.get(i).earnings());
            if (theMonth == employees.get(i).getBirthday().getMonth()){
                System.out.println("本月壽星，理應加薪!!");
            }

        sc.close(); //防止洩漏
        }
    }
}
