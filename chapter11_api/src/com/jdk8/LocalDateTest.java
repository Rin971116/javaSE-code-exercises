package com.jdk8;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/5/7 上午 02:20
 * @Version 1.0
 */
public class LocalDateTest {
    @Test
    public void test1(){
        //靜態方法
        //now(): 取得當前時間的日期、時分秒、日期+時分秒 的物件實例
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate); //2024-05-07
        System.out.println(localTime); //02:33:40.701595400
        System.out.println(localDateTime); //2024-05-07T02:33:40.701595400

        //靜態方法
        //of(): 取得指定日期、時分秒、日期+時分秒 的物件實例
        LocalDate localDate1 = LocalDate.of(2022, 12, 13);
        LocalTime localTime1 = LocalTime.of(17, 50, 12);
        LocalDateTime localDateTime2 = LocalDateTime.of(localDate1, localTime1); //localDate1 + localTime1
        LocalDateTime localDateTime1 = LocalDateTime.of(2008, 1, 30, 00, 00);

        System.out.println(localDate1);
        System.out.println(localTime1);
        System.out.println(localDateTime2);
        System.out.println(localDateTime1);


    }

    @Test
    public void test2(){
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();

        //getXxx()
        int dayOfMonth = localDate.getDayOfMonth();
        Month month = localDate.getMonth();
        System.out.println(dayOfMonth);
        System.out.println(month);

        //體現不可變性
        //withXxx(): set 的功能，new 一個新的 LocalDate 物件返回
        LocalDate localDate2 = localDate.withDayOfMonth(20);
        System.out.println(localDate); //2024-05-07
        System.out.println(localDate2); //2024-05-20

        //plusXxx(): new 一個新的 LocalDate 物件返回
        LocalDate localDate3 = localDate.plusMonths(1);// +1個月
        System.out.println(localDate); //2024-05-07
        System.out.println(localDate3); //2024-06-07

        //minusXxx()
        LocalDate localDate4 = localDate.minusYears(10);// -10年
        System.out.println(localDate);
        System.out.println(localDate4);
    }
}
