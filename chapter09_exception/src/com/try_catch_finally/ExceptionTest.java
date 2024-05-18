package com.try_catch_finally;

import org.junit.Test;

import java.util.Date;
import java.util.Scanner;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/4/10 上午 03:41
 * @Version 1.0
 */
public class ExceptionTest {

    /**
     * ArrayIndexOutOfBoundException
     */
    public void test1() {
        int[] nums = new int[10];
        System.out.println(nums[10]);

    }

    /**
     * NullPointerException
     */
    @Test
    public void test2() {
        String str = null;
        System.out.println(str.toString()); //舉例1

        int[][] nums = new int[10][];
        System.out.println(nums[9][0]); //舉例2
    }

    /**
     * ClassCastException
     */
    @Test
    public void test3() {
        Object obj = new String();
//        String str = (String) obj; 正常情況
        Date date = (Date) obj; // 舉例1 class java.lang.String cannot be cast to class java.util.Date
    }

    /**
     * NumberFormatException
     */
    @Test
    public void test4() {
        String str = "123";
        str = "abc"; //非數字
        int i = Integer.parseInt(str); //舉例1
        System.out.println(i);
    }

    /**
     * InputMismatchException
     */
    @Test
    public void test5() {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt(); //若用戶輸入非數字，就會出異常
        System.out.println(i);
    }

    /**
     * ArithmeticException 算數異常
     */
    @Test
    public void test6(){
        System.out.println(10 / 0); //運行時會發現/0，無意義，拋出異常。
    }

    //***********************************以上是運行時異常，以下為編譯時異常*************************************

    /**
     * ClassNotFoundException
     */
    @Test
    public void test7(){
//        Class clz = Class.forName("java.lang.String");
    }

    /**
     * FileNotFoundException (IOException的子類)
     * IOException
     */
    @Test
    public void test8(){
//        File file1 = new File("D:\\hello.txt"); // 可能報FileNotFoundException
//
//        FileInputStream fis = new FileInputStream(file1);
//
//        int data = fis.read(); // 可能報IOException
//        while (data != -1){
//            System.out.println((char) data);
//            data = fis.read(); // 可能報IOException
//        }
//
//        fis.close(); // 可能報IOException
    }
    
}
