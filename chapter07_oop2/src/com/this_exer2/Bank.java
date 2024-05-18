package com.this_exer2;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/12 下午 05:46
 * @Version 1.0
 */
public class Bank {

    private Customer[] customers;
    private int numberOfCustomer;

    public Bank(){
        customers = new Customer[10];
    }

    public void addCustomer(String firstName,String lastName) {
        if (numberOfCustomer < customers.length) {
            customers[numberOfCustomer] = new Customer(firstName, lastName);
            System.out.println("customer["+numberOfCustomer+"]增加成功");
            numberOfCustomer++;

        }else System.out.println("增加失敗，客戶數已達上限");
    }

    public int getNumberOfCustomers(){
        return numberOfCustomer;
    }

    public Customer getCustomer(int index){
        if (index < numberOfCustomer && index >= 0) {
            return customers[index];
        }

        System.out.println("customers["+index+"]無資料");
        return null;
    }
}
