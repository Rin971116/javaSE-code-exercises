package com.array;

import java.util.Scanner;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/1 下午 07:43
 * @Version 1.0
 */
public class LinerSearchTest {
    public static void main(String[] args) {
        int[] arr = new int[]{4,5,6,1,2,3,7,8,9};
        Scanner sc = new Scanner(System.in);
        //find target
        System.out.println("請輸入你欲search的數字:");
        int target = sc.nextInt();
        boolean isNotfind = true;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == target){
                isNotfind = false;
                System.out.println("找到了，target位於arr["+i+"]");
                break;
            }
        }
        while (isNotfind){
            System.out.println("沒找到!");
        }
    }
}
