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

//欲使用二分法 array必須要有序，時間複雜度O(logN)以2為底數

public class BinarySearchTest {
    public static void main(String[] args) {
        int[] arr2 = new int[]{2,4,5,8,12,15,19,26,37,49,51,66,89,100};
        boolean isOut = false;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("請輸入你欲search的數字:");
            int target = sc.nextInt();
            int start = 0;
            int end = arr2.length - 1;
            int mid;
            do {
                mid = (start + end) / 2;
                System.out.println("...");
                if (arr2[mid] == target) {
                    System.out.println("找到了，target位於arr2[" + mid + "]");
                    break;
                } else if (arr2[mid] > target) {
                    end = mid - 1;
                } else if (arr2[mid] < target) {
                    start = mid + 1;
                }
                if (start == mid || mid == end) {
                    System.out.println("can not find!");
                    break;
                }
            } while (true);

            loopIsOut : while (true) {
                System.out.println("是否繼續(Y/N):");
                String answer = sc.next();
                if (answer.equalsIgnoreCase("y")) {
                    isOut = true;
                    break;
                } else if (answer.equalsIgnoreCase("n")) {
                    System.out.println("退出中...");
                    isOut = false;
                    break;
                } else System.out.println("輸入錯誤:");
            }
        }while (isOut);
    }
}
