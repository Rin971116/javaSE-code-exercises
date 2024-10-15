package grammar._02_trycatch;

import org.junit.Test;

import java.io.*;

/**
 * ClassName:
 * Description:
 * (新特性) 自動關閉流 : 在原有的 try{...} catch(){...} 結構下，在 try後面加上()，並將 流的聲明都寫在這()之中，
 * 這樣 java會自動幫我們在全部執行完or異常後 關閉流資源，也就是說不用 finally{...}了
 *
 * @Author Rin
 * @Create 2024/7/10 上午 01:18
 * @Version 1.0
 */
public class TryCatchTest {
    /**
     * 原本的方式:
     * 欲讀取 使用 "非 utf-8" 的字符集編碼的文件(口訣:要讀取的是字節，所以先new IntputStream)，需要以 轉換流 包一下字節流，變成一種指定解碼集的字符流
     * 欲將其 用指定字符集編碼(口訣:最終要輸出的是字節，所以先new OutputStream)後 輸出到某文件位置，使用轉換流 包一下字節流，變成一種指定編碼集的字符流
     */
    @Test
    public void test1() {
        InputStreamReader isr = null;
        OutputStreamWriter osw = null; //表示output到file1時，使用utf-8 編碼
        try {
            File file = new File("abc_x-windows-950.txt"); //假設是一個存 x-windows-950 的字符集
            File file1 = new File("abc_utf-8.txt");

            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream(file1);

            //解碼集 需與 file 當初使用的編碼集一致，若沒提供默認使用utf-8
            //InpuutStreamReader 為一種 Reader，也就是說 是一種字符流，故這邊的操作為 將 字節流 轉換成 字符流
            isr = new InputStreamReader(fis, "x-windows-950");
            osw = new OutputStreamWriter(fos, "utf-8");

            int len;
            char[] cbuffer = new char[1024];
            while ((len = isr.read(cbuffer)) != -1) {
                String str = new String(cbuffer, 0, len);
                osw.write(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                isr.close();
                osw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 使用新特性處理: 自動關閉流資源
     */
    @Test
    public void test2() {

        try (
             FileInputStream fis = new FileInputStream("abc_x-windows-950.txt");
             FileOutputStream fos = new FileOutputStream("abc_utf-8.txt");

             //解碼集 需與 file 當初使用的編碼集一致，若沒提供默認使用utf-8
             //InpuutStreamReader 為一種 Reader，也就是說 是一種字符流，故這邊的操作為 將 字節流 轉換成 字符流
             InputStreamReader isr = new InputStreamReader(fis, "x-windows-950");
             OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
        ) {

            int len;
            char[] cbuffer = new char[1024];
            while ((len = isr.read(cbuffer)) != -1) {
                String str = new String(cbuffer, 0, len);
                osw.write(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //不需要了，會自動關閉
//        isr.close();
//        osw.close();
    }
}
