package com.file;

import org.junit.Test;

import java.io.File;

/**
 * ClassName:
 * Description:
 *                  3種構造器:
 *                          public File(String pathName)
 *                          public File(String parent, String child):第一個參數一定是文件目錄，第二個參數可以是文件目錄 or 文件，看有沒有後綴
 *                          public File(File parent, String child):第一個參數一定是文件目錄，第二個參數可以是文件目錄 or 文件，看有沒有後綴
 *
 *                   文件的路徑表示方式:
 *                          絕對路徑: 在windows系統下，包含磁碟名在內 文件或文件目錄 的完整路徑，比如: d:\io\abc.txt
 *                          相對路徑: 相對於某一個文件目錄來說，相對的位置 (不完整的路徑名，比如只寫 檔案夾名稱，至於這個檔案夾idea會認為在哪，規則如下)
 *                                  在 IDEA中，如果使用 單元測試方法: 相對於當前的 module(chapter15_io)來講
 *                                            如果使用 main方法: 相對於當前的 project(JavaSECode)來講
 *
 * @Author Rin
 * @Create 2024/5/30 上午 03:40
 * @Version 1.0
 */
public class FileTest {
    @Test
    public void test1(){
        //public File(String pathName)
        File file1 = new File("d:\\io/abc.txt"); //斜線可以用 \\ or / 表示
        File file2 = new File("abc");//文件，相對路徑

        //get 此file對象 的 絕對路徑
        System.out.println(file2.getAbsoluteFile()); //D:\Code\JavaSECode\chapter15_io\abc
    }

    public static void main(String[] args) {
        File file2 = new File("abc");//文件

        //get 此file對象 的 絕對路徑
        System.out.println(file2.getAbsoluteFile()); //D:\Code\JavaSECode\abc
    }

    @Test
    public void test2(){
        //public File(String parent, String child)
        File file1 = new File("d:\\io/abc.txt");
        File file2 = new File("d:\\io","abc.txt"); // 和file1 表達的是相同的檔案
        File file3 = new File("d:\\io","bb"); // 表示路徑 d:\io\bb，路徑只到bb這個檔案夾，沒有到具體某個檔案

        //public File(File parent, String child)
        File file4 = new File(file3,"qwe.txt");// 表示路徑 d:\io\bb\qwe.txt
    }
}
