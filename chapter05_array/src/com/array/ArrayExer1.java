package com.array;

import java.util.Scanner;

/**
 * ClassName: ArrayExer
 * Description:
 *
 * @Author Rin
 * @Create 2024/2/26 下午 06:21
 * @Version 1.0
 */

//輸入1-7，return對應星期一~星期天的英文單字
public class ArrayExer1 {
    public static void main(String[] args) {
        String[] dates = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        Scanner sc = new Scanner(System.in);
        loopStart:while (true){
            System.out.println("請輸入1-7");
            System.out.println("或是輸入0離開");
            Boolean isInt = sc.hasNextInt();//sc.hasNextInt()的特點是會將賦值存在sc.nextInt，以便呼喚
            if(isInt == false){
                System.out.println("輸入錯誤!!!!!!!!!!!!");
                sc.next();//清空sc.hasNextInt的存儲值
                continue loopStart;
            }
            int num = sc.nextInt();//調用sc.hasNextInt()暫存的賦值
            if (num == 0){
                break loopStart;
            } else if (num >= 0 && num <= 7) {
                System.out.println(dates[num-1]);
            }else {
                System.out.println("輸入錯誤!!!!!!!!!!!!");
                continue loopStart;
            }
        }
    }
}
