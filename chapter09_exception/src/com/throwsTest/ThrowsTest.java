package com.throwsTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/4/11 下午 04:59
 * @Version 1.0
 */
public class ThrowsTest {
    public static void main(String[] args) {
        method3();

        try{
            method2();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void method3(){
        try{
            method2();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
//            fis.close;
        }
    }

    public static void method2() throws FileNotFoundException, IOException {
        method1();
    }
    public static void method1() throws FileNotFoundException, IOException {
        File file1 = new File("D:\\hello.txt33"); // 可能報FileNotFoundException

        FileInputStream fis = new FileInputStream(file1);

        int data = fis.read(); // 可能報IOException
        while (data != -1){
            System.out.println((char) data);
            data = fis.read(); // 可能報IOException
        }

        fis.close(); // 可能報IOException
    }

//    public static void method1() {
//
//        FileInputStream fis = null; //在try外聲明，並且局部變量需給一個預設值，這樣出了try的作用域後還能存取該變量
//        try {
//            File file1 = new File("D:\\hello.txt33"); // 可能報FileNotFoundException
//
//            fis = new FileInputStream(file1);
//
//            int data = fis.read(); // 可能報IOException
//            while (data != -1) {
//                System.out.println((char) data);
//                data = fis.read(); // 可能報IOException
//            }
//
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) { //由於IOException為FileNotFoundException的父類，所以其實可以只寫針對IOException的處理就好
//            e.printStackTrace();
//        }finally {
//            try{
//                if(fis != null){
//                    fis.close(); // 可能報IOException 要進行異常對應處理，
//                }
//                // 若上述代碼在創建file類對象之前就報FileNotFoundException 的話，這邊就會報 NullPointerException(需處理)，
//                // 但由於我們前面說過運行時異常通常不處理，所以我們可以用if 條件判斷的方式來規避。
//            }catch(IOException e){
//                e.printStackTrace();
//            }
//        }
//        //沒有finally的一定執行性，若catch()的代碼也出異常則不會執行這部分的代碼
//        System.out.println("執行到這代表 沒有異常 or 異常處理結束 ~~");
//
//    }
}
