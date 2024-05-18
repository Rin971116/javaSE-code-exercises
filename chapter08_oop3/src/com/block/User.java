package com.block;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/26 下午 06:53
 * @Version 1.0
 */
public class User {

    private String userName;
    private String password;
    private long registrationTime;//註冊時間

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getRegistrationTime() {
        return registrationTime;
    }

    public User() {
        System.out.println("新用戶註冊");
        registrationTime = System.currentTimeMillis();
        //獲取系統當前時間(距離1970-1-1 00:00:00的毫秒數)
        userName = System.currentTimeMillis() + ""; //把long數值改成string
        password = "123456";

    }

    public User(String userName, String password) {
        System.out.println("新用戶註冊");
        this.userName = userName;
        this.password = password;
        registrationTime = System.currentTimeMillis();
    }

    public String getInfo(){
        return "用戶名:" + userName + "\t密碼:" + password + "\t註冊時間:" + registrationTime;
    }
}
