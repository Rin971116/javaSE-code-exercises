package com.array;

/**
 * ClassName: ArrayExer5
 * Description:
 *
 * @Author Rin
 * @Create 2024/2/27 下午 06:36
 * @Version 1.0
 */
public class ArrayExer5 {
    /*隨機宣告10個元素的數組，求max,min,sum,average
    求扣除max,min後的平均值
    */
    public static void main(String[] args) {
        int max,min,sum,average,sum2,average2;
        int[] arr = new int[] {56,60,82,42,81,50,70,95,41,56};
        max = arr[0];
        min = arr[0];
        sum = 0;
        average = 0;
        for (int i = 1; i <arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
            if(arr[i] < min){
                min = arr[i];
            }
            sum += arr[i];
        }
        sum2 = sum-max-min;
        average2 = sum2/ arr.length-2;
        average = sum/arr.length;
        System.out.println("max:"+max);
        System.out.println("min:"+min);
        System.out.println("sum:"+sum);
        System.out.println("average:"+average);
        System.out.println("sum2:"+sum2);
        System.out.println("average2:"+average2);
    }
}
