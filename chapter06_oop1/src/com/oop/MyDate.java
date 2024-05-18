package com.oop;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/5 下午 10:05
 * @Version 1.0
 */
public class MyDate {
    String year,month,day;
    public MyDate(String year,String month,String day){
        this.year = year;
        this.month = month;
        this.day = day;
    }
    void show(){
        System.out.println(year+"/"+month+"/"+day);
    }
}
