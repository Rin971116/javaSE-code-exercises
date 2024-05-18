package com.array;

import java.util.Scanner;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/1 下午 07:00
 * @Version 1.0
 */
public class ArrayReduceExer {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        System.out.print("arr:");
        for(int i : arr){
            System.out.print(i+"\t");
        }
        //reduce common way
        Scanner sc = new Scanner(System.in);
        System.out.println("輸入你欲刪除的元素索引(index):");
        int deleteIndex = sc.nextInt();
        for (int i = deleteIndex; i < arr.length-1; i++) {
            //length-1是為了到for loop執行到最後一個元素時找不到arr[i+1]
            arr[i] = arr[i+1];
        }
        arr[arr.length-1] = 0; //從欲刪除的元素開始，獎後面的元素全部往前推一位，最後再將最後一個元素的值賦0
        System.out.print("arr:");
        for(int i : arr){
            System.out.print(i+"\t");
        }
        //reduce way2
        System.out.println("輸入你欲刪除的元素數(由後往前刪除):");
        int deleteIndex2 = sc.nextInt();
        int[] newArr = new int[arr.length-deleteIndex2];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
        System.out.print("arr:");
        for(int i : arr){
            System.out.print(i+"\t");
        }
    }
}
