package com.annotation.junit;

import org.junit.Test;

import java.util.Scanner;

/**
 * ClassName:
 * Description:
 *              要正確編寫單元測試方法，需要滿足:
 *              - 所在的類必須是public的，非抽象的(能夠造對象)，包含唯一的無參構造器。
 *              - @Test標記的方法本身必須是public，非抽象的，非靜態的，void無返回值的，()無參數的。
 * @Author Rin
 * @Create 2024/4/7 下午 02:50
 * @Version 1.0
 */
public class JUnitTest {

    @Test
    public void test1(){
        System.out.println("test1 ...");
    }

    @Test
    public void test2(){
        System.out.println("test2 ...");

        show("我是show方法");
    }

    public int show(String info){
        System.out.println(info);
        return 10;
    }

    @Test
    public void test3(){
        Scanner sc= new Scanner(System.in);
        System.out.println("請輸入一個數值:");
        int num = sc.nextInt();
        System.out.println(num + "...");
    }

    @Test
    public void test4(){
        System.out.println("設置模板，自動生成測試方法");
    }

}
