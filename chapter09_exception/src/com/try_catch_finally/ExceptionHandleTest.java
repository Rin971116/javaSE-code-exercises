package com.try_catch_finally;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * ClassName:
 * Description:
 *
         * 執行邏輯為:
         * 執行 try{...}中的語句若出現 Exception，java會自動在發生異常的代碼處建立一個相對應的 Exception類的物件，
         * 並拋出直接跳到 catch()，一旦拋出就不執行其後的代碼了，
         * 然後從下方提供的 catch(XxxException e){...} 中找到相同類型的型參餵入，並執行其 {}中的執行語句，
         * !!若有複數個滿足的 catch() 只會執行由上到下最先滿足的一個 catch()。
 *
         * finally{...} 的使用說明:
                 * >將一定要執行的代碼寫在 finally結構中
                 * >更深刻的理解: 無論 try中或 catch中是否存在仍未被處理的異常、
                 *              無論 try中或 catch中是否存在return語句等，finally中的語句都一定要被執行。
         *
         * 為什麼要處理異常?
         * 通常不處理 "執行時異常"，反正編譯能通過，若執行時真的出異常，再回來改代碼就行。
         * 處理 "編譯時異常"，idea中常常會有明明可以執行的代碼 卻 報編譯不通過，此時代表該代碼，
         * 在某些情況下可能出錯，但根據用戶使用情形，不一定會出錯，但為防止可能出錯就乾脆在編譯時就不讓你通過，
         * 目的要你做 處理異常 的操作，使代碼 真的再使用時出錯了的情況下，該段代碼也能去處理異常。(必須做到有備無患，編譯才能通過)
 *
 * @Author Rin
 * @Create 2024/4/10 下午 09:07
 * @Version 1.0
 */
public class ExceptionHandleTest {

    /**
     * 處理 InputMismatchException 異常
     */
    @Test
    public void test5() {
        try {
            Scanner sc = new Scanner(System.in);
            int i = sc.nextInt(); //若用戶輸入非數字，就會出異常
            System.out.println(i);
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }

        System.out.println("執行到這代表 沒有異常 or 異常處理結束 ~~");
    }

//    ---------------------------以上處理執行時異常(開發中少見)，以下處理編譯時異常(開發中常見)-----------------------

    @Test
    public void test8() {

        try {
            File file1 = new File("D:\\hello.txt"); // 可能報FileNotFoundException

            FileInputStream fis = new FileInputStream(file1);

            int data = fis.read(); // 可能報IOException
            while (data != -1) {
                System.out.println((char) data);
                data = fis.read(); // 可能報IOException
            }

            fis.close(); // 可能報IOException

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) { //由於IOException為FileNotFoundException的父類，所以其實可以只寫針對IOException的處理就好
            e.printStackTrace();
        }

        System.out.println("執行到這代表 沒有異常 or 異常處理結束 ~~");

    }

}
