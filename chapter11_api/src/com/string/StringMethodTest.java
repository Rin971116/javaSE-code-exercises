package com.string;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/4/26 下午 04:00
 * @Version 1.0
 */
public class StringMethodTest {
    /**
     * String <---> char[]之間的轉換
     */
    @Test
    public void test1(){
        String str = "hello";

        //String --> char[]:調用String 的 toCharArray()
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        //char[] --> String :調用String 的構造器
        String str2 = new String(arr);
        System.out.println(str2);
    }

    /**
     * String <---> byte[]之間的轉換
     */
    @Test
    public void test2(){
        String str = "abc台灣"; //utf-8字符集下，每一個漢字用3個數字表示

        //String --> char[]:調用String 的 getBytes()

        byte[] arr = str.getBytes(); //可透過參數傳入指定字符集，默認的為UTF-8
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        byte[] arr2 = new byte[0];
        try {
            arr2 = str.getBytes("gbk"); //透過參數傳入"gbk"，使用gbk字符集，gbk字符集下，每一個漢字用2個數字表示
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }

        //byte[] --> String :調用String 的構造器
        String str2 = new String(arr);
        System.out.println(str2);

        String str3 = new String(arr2);
        System.out.println(str3);//這邊解碼時，默認使用utf-8，若編碼時使用的是gbk，此時也須傳入參數"gbk"，使用gbk字符集，否則出現亂碼

        String str4 = null;
        try {
            str4 = new String(arr2,"gbk");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(str4);
    }

    @Test
    public void test3(){
        //兩種創建方式的差別:
        String str1 = new String("hello"); //在堆空間(stack) 創建一份，並且如果LocalVariableTable 中沒有的話，也要存放一份
        String str2 = "hello"; //直接存放於LocalVariableTable 中

        //常量 + 常量 = 常量 (從LocalVariableTable拿出的)
        String str3 = "helloworld";
        String str4 = "hello" + "world";
        System.out.println(str3 == str4); //true

        //變量 + 常量 = new 新物件 (在堆空間中)
        String str5 = "hello";
        String str6 = str5 + "world";
        System.out.println(str4 == str6); //false

        //變量 + 變量 = new 新物件 (在堆空間中)
        String str7 = "world";
        String str8 = str5 + str7;
        System.out.println(str8 == str4); //false
        System.out.println(str8 == str6); //false
    }
}
