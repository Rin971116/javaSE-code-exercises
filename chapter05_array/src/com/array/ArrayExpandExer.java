package com.array;

import java.util.Scanner;

/**
 * ClassName: ArrayExpandExer
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/1 下午 02:43
 * @Version 1.0
 */
public class ArrayExpandExer {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,3,4,5};
        System.out.print("arr1:");
        for(int i : arr1){
            System.out.print(i+"\t");
        }
        System.out.println();
        //expand:
        Scanner sc = new Scanner(System.in);
        Boolean isOut = false;
        loop1:
        do {
            System.out.println("請輸入欲增加的元素數:");
            int expand = sc.nextInt();
            int[] newArr = new int[arr1.length + expand];
            for (int j = 0; j < arr1.length; j++) {
                newArr[j] = arr1[j];
            }

            arr1 = newArr;
            System.out.print("arr1:");
            for (int i : arr1) {
                System.out.print(i + "\t");
            }
            loopIsOut:
            while (true) {
                System.out.println("是否要繼續:(Y/N)");
                String answer = sc.next();

                if ("Y".equalsIgnoreCase(answer)) { //這樣寫法可以避免answer.equals()型參的不傳入null導致空指針異常
                    /*所謂的 空指針異常 是指調用 空的物件(null)的方法，編譯器會報錯，比如這邊的answer.equals("y");，若是answer指向null，
                    也就是沒有指向任何物件，那麼再判斷answer的內容是否等於"y"之前，就會先報錯，因為編譯器找不到answer所指的物件。
                    * */
                    isOut = true;
                    break loopIsOut;
                } else if ("N".equalsIgnoreCase(answer)) {
                    System.out.println("正在退出...");
                    break loop1;
                    /*也可以寫成
                    isOut = false
                    break loop2;
                     */
                } else {
                    System.out.println("輸入錯誤!");
                    continue loopIsOut;

                }
            }
        }while (true);
    }
}

