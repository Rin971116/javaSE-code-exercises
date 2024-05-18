package com.oop;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/5 下午 09:47
 * @Version 1.0
 */
public class EmployeeTest {
    public static void main(String[] args) {
        Employee ep1 = new Employee("4","Brian",23,10000,"2000","6","28");
        Employee ep2 = new Employee("5","Baby",15,10000,"2008","11","16"){
            void showInfo(){
                System.out.println("overriding");
            }
        };
        System.out.println(ep1); //print物件em1的address
        ep1.showInfo();
        System.out.println(ep2);
        ep2.showInfo();
    }
}
