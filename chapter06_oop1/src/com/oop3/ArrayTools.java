package com.oop3;

import java.util.Arrays;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/6 下午 04:39
 * @Version 1.0
 */
public class ArrayTools {
    /**
     * 獲取array中的最大值
     * @param arr 傳入的目標array
     * @return 目標中的最大值
     */
    public int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    /**
     * 獲取array中的最小值
     * @param arr 傳入的目標array
     * @return 目標中的最小值
     */
    public int getMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    /**
     * 獲取array中全部元素的和
     * @param arr 傳入的目標array
     * @return 目標array的全部元素和
     */
    public int getSum(int[] arr) {
        int sum = 0;
        for (int i = 1; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    /**
     * 獲取array全部元素的值的平均值
     * @param arr 傳入的目標array
     * @return 目標array的全部元素的平均值
     */
    public int getAverage(int[] arr) {
        int sum = 0;
        int average;
        for (int i = 1; i < arr.length; i++) {
            sum += arr[i];
        }
        average = sum / arr.length;
        return average;
    }

    /**
     * print出目標array
     * @param arr 傳入的目標array
     */
    public void showArr(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"\t");
        }
        System.out.println();
    }

    /**
     * 複製 傳入的目標array
     * @param arr 傳入的目標array
     * @return 目標array的複製物件
     */
    public int[] copyArr(int[] arr){
        int[] copyArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copyArr[i] = arr[i];
        }
        System.out.println("arr已複製");
        return copyArr;
    }

    /**
     * 對調array的前後元素
     * @param arr 傳入的目標array
     * @return 翻轉後的array
     */
    public int[] reverseArr(int[] arr){
        int temp = 0;
        for (int i = 0; i < arr.length-i; i++) {
            temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }
        System.out.println("arr已翻轉");
        return arr;
    }

    /**
     * 排序array
     * @param arr 傳入的目標array
     */
    public void sortArr(int[] arr){
        Arrays.sort(arr);
        System.out.println("arr已排序");
    }

    /**
     * 查找array中是否有 (傳入的target) 元素
     * @param arr 傳入的目標array
     * @param target 欲搜尋目標target
     */
    public void searchArr(int[] arr,int target){
        int index = Arrays.binarySearch(arr,target);
        if (index < 0){
            System.out.println("沒找到"+target);
        }else System.out.println("找到了，target位於["+index+"]");
    }
}


