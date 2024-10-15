package com.date_after_jdk8;

import org.junit.Test;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * ClassName:
 * Description:
 *                  類似於jdk8之前的 Date類
 * @Author Rin
 * @Create 2024/5/7 上午 03:16
 * @Version 1.0
 */
public class InstantTest {
    @Test
    public void test1(){
        //now():
        Instant instant = Instant.now(); // 獲取當前格林威治標準時間的實例物件
        System.out.println(instant); //2024-05-06T19:25:22.080635100Z

        //了解就行: 調整時區
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime); //2024-05-07T03:25:22.080635100+08:00

        //ofEpochMilli(): 根據指定時間戳，返回Instant類 的實例物件
        Instant instant1 = instant.ofEpochMilli(1231231231231l);
        System.out.println(instant1); //2009-01-06T08:40:31.231Z

        //toEpochMilli(): 返回Instant類物件 的對應時間戳
        long epochMilli = instant.toEpochMilli();
        System.out.println(epochMilli); //1715023986129

    }
}
