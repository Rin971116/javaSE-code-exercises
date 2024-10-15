package com.filestream;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/5/31 下午 06:59
 * @Version 1.0
 */
public class FileWriter_FileOutputStreamTest {
    @Test
    public void test1(){
        FileWriter fileWriter = null;
        FileWriter fileWriter2 = null;
        try {
            File file = new File("output.txt");

             fileWriter= new FileWriter(file); //與reader不同，writer若找不到該file，會自動幫我們建立

            fileWriter.write("hello i m Brian , ");
            fileWriter.write("or u can call me gummy");

            System.out.println("若執行到此，代表輸出成功");

            fileWriter2 = new FileWriter(file); //與reader不同，writer若找不到該file，會自動幫我們建立

            fileWriter2.write("coverfile");


            System.out.println("若執行到此，代表output.txt 被部分覆蓋了"); //在fileWriter關閉流之前就也在output.txt進行寫入，像同時編輯的情況

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close(); //沒有關閉流 = 編輯後沒有存檔那種感覺
                fileWriter2.close(); //沒有關閉流 = 編輯後沒有存檔那種感覺
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 覆蓋原有文件的方式
     */
    @Test
    public void test2(){
        FileWriter fileWriter2 = null;
        try {
            File file = new File("output.txt");

            fileWriter2 = new FileWriter(file); //與reader不同，強制會自動幫我們建立，若file已存在也會將原本的內容覆蓋掉

            fileWriter2.write("coverfile ALL");


            System.out.println("若執行到此，代表output.txt 被覆蓋了");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 在現有的文件上，繼續添加內容的方式
     */
    @Test
    public void test3(){
        FileWriter fileWriter2 = null;
        try {
            File file = new File("output.txt");

//            fileWriter2 = new FileWriter(file,false); //與無參構造器相同，不接著寫 = 覆蓋
            fileWriter2 = new FileWriter(file,true); //與無參構造器不同，若file已存在 將會接著繼續寫(當append = true時)

            fileWriter2.write("This way will not cover this file , ");
            fileWriter2.write("it will continue append.");


            System.out.println("若執行到此，代表append成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
