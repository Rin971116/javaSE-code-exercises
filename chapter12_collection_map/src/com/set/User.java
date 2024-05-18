package com.set;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/5/15 上午 03:12
 * @Version 1.0
 */
public class User implements Comparable{
    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        User user = (User) o;
//        return age == user.age && Objects.equals(name, user.name);
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(name, age);
//    }

    @Override
    public int compareTo(Object o) throws ClassCastException{
        if (o instanceof User){
            User u = (User) o;
            int value = this.age - u.age;
            if (value == 0){
                return -this.name.compareTo(u.name); //加上-號，輸出結果相反
            }else return value;
        }
        throw new ClassCastException("類型不匹配");
    }


}
