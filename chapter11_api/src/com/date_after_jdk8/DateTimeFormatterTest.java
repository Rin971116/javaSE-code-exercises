package com.date_after_jdk8;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * ClassName:
 * Description:
 *              類似於jdk8之前的 SimpleDateFormat類，一種轉換工具類，建立其對象時傳入String類的 指定格式，作為 轉化/讀取 的唯一規則
 * @Author Rin
 * @Create 2024/5/7 上午 03:34
 * @Version 1.0
 */
public class DateTimeFormatterTest {
    @Test
    public void test1(){

        //ofPattern(): 靜態方法，透過類去調，獲取 DateTimeFormatter的實例
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd , HH:mm:ss");

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        //format(): 將LocalDateTime對象，轉換成符合 讀取格式 的字串
        String localDateTimeFormat = dtf.format(localDateTime);
        System.out.println(localDateTimeFormat);

        //parse(): 將符合 讀取格式 的字串，轉換成TemporalAccessor類對象，再透過LocalDateTime.from(TemporalAccessor t)轉換成LocalDateTime對象
        TemporalAccessor temporalAccessor = dtf.parse("2008-01-30 , 00:00:00");
        LocalDateTime localDateTime1 = LocalDateTime.from(temporalAccessor);
        System.out.println(localDateTime1);
    }
}
