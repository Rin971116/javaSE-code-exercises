package com.file.exer2;

import java.io.File;
import java.io.FilenameFilter;

/**
 * ClassName:
 * Description:
 *                  題目: 判斷指定目錄下是否有後綴名為.png的文件，如果有，則輸出該文件名
 * @Author Rin
 * @Create 2024/5/30 上午 06:52
 * @Version 1.0
 */
public class Exer2 {
    public static void main(String[] args) {
        File dir = new File("C:\\Users\\Owner\\maple");

        //方式1.
        String[] list = dir.list();
        for (String fileName : list){
            if (fileName.endsWith(".png")){
                System.out.println(fileName);
            }
        }

        //方式2. 使用public String[] list(FilenameFilter)
        String[] list1 = dir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) { //參數的 name 指 文件名
                return name.endsWith(".png"); //return true 才會放到String[]中
            }
        });
        for (String fileName : list1){
            System.out.println(fileName);
        }
    }

}
