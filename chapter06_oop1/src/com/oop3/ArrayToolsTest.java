package com.oop3;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/6 下午 04:54
 * @Version 1.0
 */
public class ArrayToolsTest {
    public static void main(String[] args) {
        ArrayTools at1 = new ArrayTools();
        int[] arr = new int[]{1,5,4,3,2,8,1,65,44,2,1};
        System.out.println(at1.getSum(arr));
        System.out.print("arr:");
        at1.showArr(arr);
        System.out.println("min:"+ at1.getMin(arr));
        System.out.println("max:"+ at1.getMax(arr));
        int[] arr2 = at1.copyArr(arr);
        System.out.print("arr2:");
        at1.showArr(arr2);
        System.out.println(arr == arr2);
        at1.reverseArr(arr2);
        System.out.print("arr2:");
        at1.showArr(arr2);
        at1.sortArr(arr2);//do sort
        System.out.print("arr2:");
        at1.showArr(arr2);

        at1.sortArr(arr);//do sort
        System.out.print("arr:");
        at1.showArr(arr);

        at1.searchArr(arr2, 8);
        at1.searchArr(arr2, 100);
    }
}
