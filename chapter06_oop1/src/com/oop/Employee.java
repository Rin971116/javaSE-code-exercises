package com.oop;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/5 下午 10:00
 * @Version 1.0
 */
public class Employee {
    String id;
    String name;
    int age;
    int salary;
    MyDate birthday;
    public Employee(String id, String name, int age, int salary, String year, String month, String day){
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        birthday = new MyDate(year,month,day);
    }

    void showInfo(){
        System.out.print("id:"+id+"\t");
        System.out.print("name:"+name +"\t");
        System.out.print("age:"+age+"\t");
        System.out.println("salary:"+salary+"\t");
        System.out.print("birthday:");
        birthday.show();
    }
}

