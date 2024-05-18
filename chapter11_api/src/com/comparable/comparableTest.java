package com.comparable;

import org.junit.Test;

import java.util.Arrays;

/**
 * ClassName:
 * Description:
 *              自然排序: Let the class that need to compare implements Comparable interface, and override compareTo(), as a compare rule.
 *              調用Comparable實現類所重寫的 compareTo()，作為比較規則
 * @Author Rin
 * @Create 2024/5/7 下午 06:28
 * @Version 1.0
 */
public class comparableTest {
    @Test
    public void test1(){
        String[] arr = new String[]{"Tom","Jerry","Brian","Steven","Gummy","Kevin"};
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    @Test
    public void test2(){
        Product[] products = new Product[5];
        products[0] = new Product(5600,"iphone15","apple");
        products[1] = new Product(2330,"iphone10","apple");
        products[2] = new Product(4500,"iphone14","apple");
        products[3] = new Product(3100,"iphone13","apple");
        products[4] = new Product(4500,"iphone13plus","apple");
        System.out.println(products[0].getPrice());

        Arrays.sort(products); //默認由compareTo()取得的返回值 由小排到大
        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i]);
        }
    }

    @Test
    public void test3(){
        String str1 = "gummy";
        String str2 = "gummy";
        String str3 = str1 + str2;
        System.out.println(str1 == str2);
        System.out.println(str3 == str1 + str2);
        StringBuilder stringBuilder;
        StringBuffer stringBuffer;//thread safe
    }
}
