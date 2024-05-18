package com.constructor.javabean;

import java.util.Date;

/**
 * ClassName:
 * Description:
 *
 * 所謂 JavaBean ，是指符合如下標準的java類；
 *
 * - 類是公共的
 * - 有一個 無參數版本 的constructor
 * - 有屬性，且有對應的 get()、set()方法
 *
 * @Author Rin
 * @Create 2024/3/11 上午 03:18
 * @Version 1.0
 */
public class Constructor {
     public Constructor(){

     };
     private int id;
     private String name;
     private String email;
     private Date birthday;
     //一鍵生成get()、set()，鍵盤輸入alt + insert

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
