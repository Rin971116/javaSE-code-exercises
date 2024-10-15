package com.filestream;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/5/31 下午 06:59
 * @Version 1.0
 */
public class FileReader_FileInputStreamTest {
    /**
     * 基礎方法，一個一個獲取字符
     */
    @Test
    public void test1() {
        FileReader fileReader = null; //流關閉時，需要調用fileReader，所以聲名在外面
        try {
            File file = new File("hello.txt");

            fileReader = new FileReader(file);

//        fileReader.read(): 每調用一次往後一位，類似跌代器的用法(iterator)，return -1時，表示沒讀到了，表結束
//        System.out.println((char) fileReader.read()); //104 -> 'h'
//        System.out.println((char) fileReader.read()); //101 -> 'e'

            int read;
            while ((read = fileReader.read()) != -1){
                System.out.print((char) read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 提供一個 char[i]，一次讀取 char[i]，讓內存(cpu毫秒級別)少跟磁碟(秒級別)交互，增加效率
     */
    @Test
    public void test2(){
        FileReader fileReader = null; //流關閉時，需要調用fileReader，所以聲名在外面
        try {
            File file = new File("hello.txt");

            fileReader = new FileReader(file);

            char[] cBuffer = new char[5]; //載具的概念，用去裝讀入的字符
            int length;

            //返回當輪讀到的字符數量，返回-1 則代表讀不到了，結束
            //由於我們提供的容器為char[5]，所以代表一次最多 也就讀到5個，讀到最後可能不是剛好滿5個字符時，可能是0~5，故不能用cBuffer.length作控制式
            while ((length = fileReader.read(cBuffer)) != -1){
                for (int i = 0; i < length; i++) {
                    System.out.print(cBuffer[i]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
