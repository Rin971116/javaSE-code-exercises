package com.array;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/2 上午 03:11
 * @Version 1.0
 */
public class QuickSortTest {
    public static void main(String[] args) {
        int[] arr = new int[] {35,54,3,2,65,7,34,5,76,34,67,90,80,40,50,2,1,5,50,44,111,21,0,0};
        System.out.println("arr:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"\t");
        }
        System.out.println();
        QuickSort.quickSort(arr,0,arr.length-1);
        System.out.println("arr:");
        for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]+"\t");
        }
    }
}

class QuickSort{
    static void quickSort(int[] arr, int startIndex, int endIndex){
        System.out.println("startIndex = "+startIndex);
        System.out.println("endIndex = "+endIndex);
        int temp;
        int lastEnd = endIndex;
        //recusion結束條件
        if (startIndex > endIndex){
            return;
        }

        loopFindBigger:
        for (int i = startIndex+1; i <= endIndex; i++) {
            System.out.println("i = "+i);
            //先由左到右找大於standard的數
            if (arr[i] >= arr[startIndex] || i == endIndex){
                System.out.println("i ="+i+"滿足");

                for (int j = lastEnd; j > startIndex; j--) {
                    System.out.println("j ="+j);
                    lastEnd = j-1;

                    //找到大於的，再由右到左找小於standard的數
                    if (arr[j] <= arr[startIndex]){
                        System.out.println("j ="+j+"有執行");

                        if(i < j) {//兩者都找到後，確認是否交叉了，尚未交叉再進行交換位置
                            temp = arr[i];
                            arr[i] = arr[j];
                            arr[j] = temp;
                            show(arr);
                            //交換完，尋找下一個比standard大的數
                            continue loopFindBigger;
                        } else if (i >= j) {//交叉了，則排序完成，進行交換arr[startIndex]跟arr[j]
                            temp = arr[j];
                            arr[j] = arr[startIndex];
                            arr[startIndex] = temp;
                            show(arr);
                            System.out.println("--------");
                            //交換完，
                            lastEnd = j;
                            System.out.println("lastEnd ="+lastEnd);

                            break loopFindBigger;
                        }
                    }
                }
            }
        }

        quickSort(arr, startIndex, lastEnd - 1);
        quickSort(arr, lastEnd + 1, endIndex);
    }

    static void show(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"\t");
        }
        System.out.println();
    }
}

