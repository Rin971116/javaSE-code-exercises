package com.objectstream;

import java.io.Serializable;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/6/5 下午 01:09
 * @Version 1.0
 */
public class Person implements Serializable {
    private transient String name; //transient 修飾，代表不會被序列化，當物件被序列化保存時，會以該屬性的默認值存儲，比如0、null、false
    private static int age;

    private Account account;

    private static final long serialVersionUID = 424746L;

    public Person() {
    }

    public Person(String name, int age, Account account) {
        this.name = name;
        this.age = age;
        this.account = account;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", account=" + account +
                '}';
    }


}

class Account implements Serializable{

    private static final long serialVersionUID = 424788846L;

    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }
}
