package com.comparator;

import com.comparable.Product;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ClassName:
 * Description:
 *                  創建Comparator實現類，透過在實現類中重寫 compare(Object o1, Object o2)
 *
 *
 * @Author Rin
 * @Create 2024/5/8 上午 10:44
 * @Version 1.0
 */
public class ComparatorTest {

    @Test
    public void test1(){
        String[] arr = new String[]{"Tom","Jerry","Brian","Steven","Gummy","Kevin"};

        Comparator c = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof String && o2 instanceof String) {
                    String s1 = (String) o1;
                    String s2 = (String) o2;

                    return -s1.compareTo(s2); //String類提供的compareTo()，規則一樣return 0/1/-1，這邊使用-號，使排序相反
                }
                throw new RuntimeException("類型不匹配");// 單純手動提供異常，讓編譯通過，並沒有向外拋出 或 try/catch，等於並沒有處理異常
            }
        };

        //自然排序: 通過調用Comparable實現類所重寫的 compareTo()，作為比較規則
        Arrays.sort(arr);   //默認 由小到大排，也就是a --> z
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println("-------------------------------------------");

        //訂製排序: 通過提供Comparator實現類(c)，並以實現類中提供的compare()作為 比較規則
        Arrays.sort(arr,c); //通過參數傳入一個Comparator實現類的參數，表示使用該參數作為 比較規則
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    @Test
    public void test2() {
        Product[] products = new Product[5];
        products[0] = new Product(5600, "iphone15", "apple");
        products[1] = new Product(2330, "iphone10", "apple");
        products[2] = new Product(4500, "iphone14", "apple");
        products[3] = new Product(3100, "iphone13", "apple");
        products[4] = new Product(4500, "iphone13plus", "apple");

        //提供Comparator的實現類的對象，這邊的做法為提供匿名實現類的匿名對象
        Comparator c = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Product && o2 instanceof Product) {
                    Product p1 = (Product) o1;
                    Product p2 = (Product) o2;

                    return Integer.compare(p1.getPrice(),p2.getPrice());
                }
                throw new RuntimeException("類型不匹配");
            }
        };

        Arrays.sort(products,c); //多傳入一個Comparator實現類的參數，表示使用該參數作為 比較規則
        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i]);
        }
    }
}
