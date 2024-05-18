package com.object.equals.exer1;

import java.util.Objects;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/21 下午 06:42
 * @Version 1.0
 */
public class User {

    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //重寫equals

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj){
//            return true;
//        }
//
//        if (obj instanceof User){
//            User anotherUser = (User)obj;
//            //方法1.
////            if (this.name.equals(anotherUser.name) && this.age == anotherUser.age){
////                return true;
////            }
////            else {
////                return false;
////            }
              //方法2.
//            return this.name.equals(anotherUser.name) && this.age == anotherUser.age;
//        }
//        else return false;
//    }

    //IDEA自動實現
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name);
    }

}
