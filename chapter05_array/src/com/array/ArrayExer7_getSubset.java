package com.array;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/5 下午 06:36
 * @Version 1.0
 */
public class ArrayExer7_getSubset {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,-2,3,10,-4,7,2,-5};
        int[][] arr2 = new int[arr1.length][arr1.length];
        int sum;
        boolean[][] isFill = new boolean[arr1.length][arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            sum = arr1[i];
            arr2[i][i] = sum;
            isFill[i][i] = true;
            for (int j = i+1; j < arr1.length; j++) {
                sum += arr1[j];
                arr2[i][j] = sum;
                isFill[i][j] = true;
            }
        }

        int maxSum = arr2[0][0];
        int maxSumI=0 , maxSumJ=0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                if (isFill[i][j]){
                    System.out.println("(index:"+i+"-"+j+") 的子集合和:"+arr2[i][j]);
                    if (arr2[i][j] > maxSum){
                        maxSum = arr2[i][j];
                        maxSumI = i;
                        maxSumJ = j;
                    }
                }
            }
        }
        System.out.println("maxSum:"+"(index:"+maxSumI+"-"+maxSumJ+") 的子集合和:"+maxSum);
    }
}
