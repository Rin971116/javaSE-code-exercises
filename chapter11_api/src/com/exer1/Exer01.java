package com.exer1;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/5/6 下午 03:56
 * @Version 1.0
 */

public class Exer01 {
    /**
     * Q1: 將java.util.Date 物件轉換成 java.sql.Date date2 物件
     */
    @Test
    public void test1(){
        java.util.Date date1 = new Date(); //取得當前系統時間的java.util.Date類物件
        System.out.println(date1);
        java.sql.Date date2 = new java.sql.Date(1321321321321l); //取得一個指定時間戳的java.sql.Date類物件
        System.out.println(date2);

        //question1: 如何將java.util.Date 物件轉換成java.sql.Date date2 物件?
        java.sql.Date date3 = new java.sql.Date(date1.getTime());
        System.out.println(date3);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd , HH:mm:ss");
        String date3Format = sdf.format(date3);
        System.out.println(date3Format);
    }

    /**
     * Q2: 獲取一個 2022/12/13 的 java.sql.Date 物件
     * @throws ParseException
     */
    @Test
    public void test2() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse("2022-12-13");

        System.out.println(date1);

        java.sql.Date date2 = new java.sql.Date(date1.getTime());
        System.out.println(date2);


    }
}
