package com.array;

/**
 * ClassName: ArrayExer3
 * Description:
 *
 * @Author Rin
 * @Create 2024/2/27 下午 02:35
 * @Version 1.0
 */

//獲取array中所有元素的和
public class ArrayExer3 {
    public static void main(String[] args) {
        int sum = 0;
        int[][] ia1 = new int[][] {{3,5,8},{12,9},{7,0,6,4}};
        for (int i = 0; i < ia1.length; i++) {
            for (int j = 0; j < ia1[i].length; j++) {
                sum += ia1[i][j];
            }
        }
        System.out.println(sum);
    }
}
