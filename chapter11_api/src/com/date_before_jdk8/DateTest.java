package com.date_before_jdk8;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * ClassName:
 * Description:
 *              Date有兩種:
 *                      1. java.util.Date:
 *                              兩個構造器
 *                              兩個方法的使用: 1.toString()
 *                                            2.long getTime()，取得當前系統時間 的 時間戳
 *
 *                      2. java.sql.Date: 對應著數據庫中的 Date類型
 *                              一個構造器
 *                              兩個方法的使用: 1.toString()
 *                                            2.long getTime()
 * @Author Rin
 * @Create 2024/5/3 下午 04:38
 * @Version 1.0
 */
public class DateTest {
    /**
     * java.util.Date 的實例化、常用方法
     */
    @Test
    public void test1(){
        Date date1 = new Date();//創建一個基於當前系統時間的Date實例
        System.out.println(date1.toString());

        //getTime()
        long milliTimes = date1.getTime();
        System.out.println("對應的毫秒數:" + milliTimes);//1714725996056，時間戳: 1970/1/1,00:00 距當今時刻的毫秒數

        Date date2 = new Date(1314725996056l); //建立一個基於指定時間戳的Date實例
        System.out.println(date2);

    }

    /**
     * java.sql.Date 的實例化、常用方法
     */
    @Test
    public void test2(){
        java.sql.Date sqlDate1 = new java.sql.Date(1314725996056l);
        System.out.println(sqlDate1.toString());

        System.out.println(sqlDate1.getTime());
    }

    /**
     * SimpleDateFormat類 像一個轉換工具的類，用來將 Date類、指定格式下的 String之間互相轉換
     * 用法: 透過 SimpleDateFormat類的對象調用 format()，返回指定格式字符串。 Date ---> String
     *      透過 SimpleDateFormat類的對象調用 parse()，返回一個Date類物件。 String ---> Date
     */
    @Test
    public void test3() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat();// 2024/5/4 上午1:08 轉換的默認格式
        Date date1 = new Date();
        System.out.println(date1);

        //格式化: Date ---> String，返回一個String
        String str = sdf.format(date1);
        System.out.println(str);

        //解析: String ---> Date，返回一個Date類物件
        Date date2 = sdf.parse("2024/5/4 上午1:08"); // 2024/5/4 上午1:08 接受的默認格式String
        System.out.println(date2); //Sat May 04 01:08:00 CST 2024
    }

    /**
     * 常用的格式，寫成 String作為參數傳入 SimpleDateFormat構造器，建立指定格式的轉換工具
     * @throws ParseException
     */
    @Test
    public void test4() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z"); //透過參數傳入指定格式
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //常用的格式

        Date date1 = new Date();
        //格式化(format)
        String str = sdf.format(date1);
        System.out.println(str);

        //解析(parse)
        Date date2 = sdf.parse("2000-06-28 02:20:11"); //傳入指定格式的string
        System.out.println(date2); // Wed Jun 28 02:20:11 CST 2000
    }

    /**
     * Calendar: 日曆類
     * 1. 實例化 由於 calendar是抽象類，不能造對象，只能造其子類對象，即 GregorianCalendar
     * 2. 常用方法 :
     *              1.get(int field)
     *              2.set(int field, int newValue)
     *              3.add(int field, int addDayAmount)
     *              4.getTime(Date date1)
     *              5.setTime(Date date2)
     */
    @Test
    public void test5(){
        //方法1. 建立GregorianCalendar類的物件
        Calendar c1 = new GregorianCalendar();

        //方法2. 調用Calendar 的靜態方法 getInstance()，返回的也是一個GregorianCalendar類的物件
        Calendar c2 = Calendar.getInstance();

        //Calendar類中的屬性多為static，因此也可以透過類去調用
        //1. get(int field)
        c1.get(Calendar.DAY_OF_MONTH);  //這個月的第幾天
        System.out.println(c1.get(Calendar.DAY_OF_MONTH));
        c2.get(Calendar.DAY_OF_YEAR);  //今年的第幾天

        //2. set(int field, xx)
        c1.set(Calendar.DAY_OF_MONTH,23);  //更改今天為這個月的第23天
        System.out.println(c1.get(Calendar.DAY_OF_MONTH));

        //3. add(int field, int newValue) 今天為基礎加幾天
        c1.add(Calendar.DAY_OF_MONTH,2); //+2天
        System.out.println(c1.get(Calendar.DAY_OF_MONTH));
        c1.add(Calendar.DAY_OF_MONTH,-5); //-5天
        System.out.println(c1.get(Calendar.DAY_OF_MONTH));

        //4. getTime(): Calendar ---> Date
        Date date1 = c1.getTime();
        System.out.println(date1); // Mon May 20 15:51:35 CST 2024

        //5. setTime(): 用指定的Date，使Calendar reset
        Date date2 = new Date();// 建立當下系統時間的date
        c1.setTime(date2);
        System.out.println(c1.get(Calendar.DAY_OF_MONTH)); // 6，回到當天的日期
    }
}
