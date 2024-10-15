package com.file.exer1;

import java.io.File;
import java.io.IOException;

/**
 * ClassName:
 * Description:
 *              題目: 先創建一個 hello.txt的 File類對象，
 *                   再創建一個與 hello.txt文件在相同文件目錄下的 另一個名為 abc.txt的文件
 * @Author Rin
 * @Create 2024/5/30 上午 06:38
 * @Version 1.0
 */
public class Exer1 {
    public static void main(String[] args) {
        File file1 = new File("hello.txt");
        try {
            if (file1.createNewFile()){
                System.out.println("file1 創建成功");
            }else System.out.println("file1 創建失敗");
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file2 = new File(file1.getAbsoluteFile().getParent(), "abc.txt");

        System.out.println(file1.getAbsolutePath());
        System.out.println(file2.getAbsolutePath());
    }
}
