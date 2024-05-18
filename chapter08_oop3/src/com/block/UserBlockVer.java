package com.block;

/**
 * ClassName:
 * Description:
 *         簡而言之，block的好處在於，當你要設定屬性的初值時，一行搞不定，
 *         需要再建立物件之前，就執行某些程序(比如說先造其他對象，外加調方法等) <-------- 非 static block
 *         需要在加載類之前，就執行某些程序(比如說先造其他對象，外加調方法等) <-------- static block (較為重要一點)
 *
 * @Author Rin
 * @Create 2024/3/26 下午 07:05
 * @Version 1.0
 */
public class UserBlockVer {

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

//非靜態block可利用於 初始化 各構造器相同的部分(全部都要做的，可以拿出來寫一遍就好)
    {
        System.out.println("新用戶註冊");
        registrationTime = System.currentTimeMillis();
    }
    public UserBlockVer() {
        userName = System.currentTimeMillis() + ""; //把long數值改成string
        password = "123456";

    }

    public UserBlockVer(String userName, String password) {
        this.userName = userName;
        this.password = password;

    }

    public String getInfo(){
        return "用戶名:" + userName + "\t密碼:" + password + "\t註冊時間:" + registrationTime;
    }
}
