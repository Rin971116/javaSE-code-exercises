package com.use;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/5/23 下午 07:10
 * @Version 1.0
 */
public class Employee implements Comparable<Employee>{ //可以解讀成Comparable<Employee> 是 Comparable的進階用法，給自己設下規定的使用方法，
                                                       //若忘記了，直接去看Comparable的原碼，一看便知泛型的用意。
    private String name;
    private int age;
    private String id;

//    private Date date;

    public Employee() {
    }

    public Employee(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id='" + id + '\'' +
                '}';
    }


    @Override
    //因為implements時 宣告成Comparable<Employee>，由於Comparable中的設計方式，實現的抽象方法就會是public int compareTo(Employee o){}
    //自然排序: id -> name -> age
    public int compareTo(Employee o) {
        //1. 比id
        int idDiff = this.id.compareTo(o.id);
        if (idDiff != 0){
            return idDiff;
        }

        //2. 比姓名
        int nameDiff = this.name.compareTo(o.name);
        if (nameDiff != 0){
            return nameDiff;
        }

        //3. 比年紀
        return this.age - o.age;

    }
}
