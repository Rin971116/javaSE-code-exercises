package com.exer2;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * ClassName:
 * Description:
 *              Q: 獲取自己生日的日期，以及過了100天後的日期
 * @Author Rin
 * @Create 2024/5/7 上午 03:52
 * @Version 1.0
 */
public class Exer2 {
    /**
     * 使用 Calendar
     */
    @Test
    public void test1(){

        Calendar instance = Calendar.getInstance(); // 實例化方法1
        Calendar c = new GregorianCalendar(); // 實例化方法2


        instance.set(2000,06,28);
        Date date1 = instance.getTime();

        instance.add(Calendar.DAY_OF_YEAR,100);

        Date date2 = instance.getTime();
        System.out.println("我的生日:" + date1);
        System.out.println("過了100天後:" + date2);
    }

    /**
     * 使用 LocalDateTime
     */
    @Test
    public void test2(){
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = localDateTime.withYear(2000);
        LocalDateTime localDateTime2 = localDateTime1.withMonth(6);
        LocalDateTime localDateTime3 = localDateTime2.withDayOfMonth(28);

        LocalDateTime localDateTime4 = localDateTime3.plusDays(100);

        System.out.println("我的生日:" + localDateTime3);
        System.out.println("過了100天後:" + localDateTime4);
        System.out.println(localDateTime); //不可變性
    }
}
