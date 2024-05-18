package com.arrays;

import java.util.Arrays;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/4 下午 07:00
 * @Version 1.0
 */
public class ArraysTest {
    public static void main(String[] args) {
        //介紹一些常用的Arrays的方法
        //1.boolean equals(int[] a ,int[] b);
        int[] arr1 = new int[]{1,2,3,4,5};
        int[] arr2 = new int[]{1,2,3,4,5};
        Boolean isEquals = Arrays.equals(arr1,arr2); //問其內容是否相同，而非是否為同一個物件
        System.out.println(isEquals);

        arr2 = new int[]{1,2,3,5,4};
        System.out.println(Arrays.equals(arr1,arr2)); //兩個數組的內容、順序要完全一致才是true

        //2.String toString(int[] a);
        System.out.println(arr1); //print object address
        System.out.println(Arrays.toString(arr1)); //print array contents

        //3.void fill(int[] a, int val); 將指定值填充到數組之中
        Arrays.fill(arr1,10); //將arr1中的所有元素都替換成了10
        System.out.println(Arrays.toString(arr1));
        Arrays.fill(arr1,0,1,20); //實際更改為 fromIndex ~ toIndex-1 的元素
        System.out.println(Arrays.toString(arr1));

        //4.void sort(int[] a); //使用quickSort 排序
        int[] arr3 = new int[]{211,50,4,60,20,7,9,12,40,50,30,1116};
        Arrays.sort(arr3);
        System.out.println(Arrays.toString(arr3));

        //5.int binarySearch(int[] a, int key); 二分查找，注意!!前提當然是數組要是排序好的
        Arrays.binarySearch(arr3,1116); //return的值為 key在array中的index
        System.out.println(Arrays.binarySearch(arr3,1116));

        System.out.println(Arrays.binarySearch(arr3,1117)); //如果沒找到的話則return負數

        //因此可以這樣去print
        int index = Arrays.binarySearch(arr3,1117);
         if(index >= 0){
             System.out.println(index);
         }else System.out.println("沒找到");

         //NullPointerException 情況3
         String[] str1 = new String[3];
         //System.out.println(str1[0].toString()); 會報錯，String[] 代表建了3個空間(存放3個String物件的空間)，但尚未建立String物件
         //因此當要去調用String裡面的toString()方法時，會報錯，因為str1[0]並未指向任何string物件

    }
}
