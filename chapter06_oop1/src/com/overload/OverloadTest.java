package com.overload;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/7 上午 02:00
 * @Version 1.0
 */
public class OverloadTest {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        System.out.println(arr); //return address

        char[] arr2 = new char[]{'a','b','c'};
        System.out.println(arr2); //特例!!!! System.out.println(char[] ch)特別寫成會幫你遍歷後return 一個(String)。

        double[] arr3 = new double[]{1.1,2.2,3.3};
        System.out.println(arr3); //return address

        String[] arr4 = new String[]{"a","b","c"};
        System.out.println(arr4); //return address
    }
}
