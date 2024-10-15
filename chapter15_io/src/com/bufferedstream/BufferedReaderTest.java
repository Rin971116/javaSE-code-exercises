package com.bufferedstream;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/6/4 上午 09:30
 * @Version 1.0
 */
public class BufferedReaderTest {

    /**
     * readLine(): 返回值為讀取到的 一行一行的 string，故不用提供數組容器了，若讀完則返回 null
     * 可以搭配 write(String str)使用
     */
    @Test
    public void test1(){
        BufferedReader br = null;
        try {
            File file = new File("hello.txt");
            br = new BufferedReader(new FileReader(file));

            String str = null;
            while ((str = br.readLine()) != null){ // 返回值為讀取到的string，若讀完則返回null
//                System.out.print(str);
                System.out.println(str); // 注意readLine()返回值不包含每行句尾默認的"\n"，代表需要自行換行
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
