package com.array;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/2 上午 02:52
 * @Version 1.0
 */
public class BubbleSortTest {
    public static void main(String[] args) {
        int[] arr = new int[] {35,54,3,2,65,7,34,5,76,34,67};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"\t");
        }
        //bubble sort
        System.out.println();
        int temp;
        for (int round = 0; round < arr.length; round++) {

            for (int i = 0; i < arr.length - 1-round; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"\t");
        }
    }
}
