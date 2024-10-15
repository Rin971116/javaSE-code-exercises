package com.inputstreamreader;

import org.junit.Test;

import java.io.*;

/**
 * ClassName:
 * Description:
 *                  轉換流 InputStreamReader, OutputStreamWriter 的使用
 *                  將 InputStream ---> Reader ,  Writer ---> OutputStream
 *                      (字節流)   ---> (字符流)   (字符流) --->   (字節流)
 *                      (看不懂)   ---> (看得懂)   (看得懂) --->   (看不懂)
 *                  常見用途:
 *                          1.使用 指定編碼集讀 、 指定編碼集寫
 *                          2.有需求時 將得到的流 轉換成字符 or 字節流 使用
 * @Author Rin
 * @Create 2024/6/5 上午 06:31
 * @Version 1.0
 */
public class InputStreamReaderTest {
    @Test
    public void test1() throws IOException {
        File file = new File("abc_x-windows-950.txt"); //假設是一個存UTF-8的字符集

        FileInputStream fis = new FileInputStream(file);

        //解碼集 需與 file 當初使用的編碼集一致，若沒提供默認使用utf-8
        InputStreamReader isr = new InputStreamReader(fis,"x-windows-950");

        int len;
        char[] cbuffer = new char[1024];
        while ((len = isr.read(cbuffer)) != -1){
            String str = new String(cbuffer,0,len);
            System.out.println(str);
        }

        isr.close();
    }

    @Test
    public void test2() throws IOException {
        File file = new File("abc_x-windows-950.txt"); //假設是一個存 x-windows-950 的字符集
        File file1 = new File("abc_utf-8.txt");

        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(file1);

        //解碼集 需與 file 當初使用的編碼集一致，若沒提供默認使用utf-8，使用utf-8的情況下，也不用使用轉換流了，因為編譯器預設用utf-8解碼，用字節流就行
        //InpuutStreamReader 為一種 Reader，也就是說 是一種字符流，故這邊的操作為 將 字節流 轉換成 字符流
        InputStreamReader isr = new InputStreamReader(fis,"x-windows-950");
        OutputStreamWriter osw = new OutputStreamWriter(fos,"utf-8"); //表示output到file1時，使用utf-8 編碼

        int len;
        char[] cbuffer = new char[1024];
        while ((len = isr.read(cbuffer)) != -1){
            String str = new String(cbuffer,0,len);
            osw.write(str);
        }

        isr.close();
        osw.close();
    }

    @Test
    public void test3() throws IOException {
        File file = new File("abc_x-windows-950.txt");
        FileOutputStream fos = new FileOutputStream(file);
        OutputStreamWriter osw = new OutputStreamWriter(fos,"x-windows-950");

        osw.write("這是一個測試文本，使用x-windows-950字符集編碼");
//        osw.flush();

        osw.close();
    }
}
