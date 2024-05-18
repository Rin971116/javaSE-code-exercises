package com.exer2;

import java.util.Scanner;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/4/15 下午 06:48
 * @Version 1.0
 */
public class DivisionDemoTest {
    public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

        try {
            System.out.print("dividend: ");
            int dividend = sc.nextInt();
            System.out.print("\ndivisor: ");
            int divisor = sc.nextInt();

            System.out.println(dividend + " / " + divisor + " = " + DivisionDemo.divide(dividend, divisor));
        }catch(BelowZeroException e){
            e.printStackTrace();
        }finally {
            sc.close();
            System.out.println("sc關閉...");
        }
    }

}
