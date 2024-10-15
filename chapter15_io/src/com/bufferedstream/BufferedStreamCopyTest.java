package com.bufferedstream;

import org.junit.Test;

import java.io.*;

/**
 * ClassName:
 * Description:
 *              在文件流(file stream)的基礎上，再包一層 buffered stream，原理是buffered stream會在內存多設置一個空間，
 *              暫存那些要要寫的 要讀的字符 or 字節，存多一點 再跟磁碟交互，進而減少跟磁碟交互的次數，而增加效率
 * @Author Rin
 * @Create 2024/6/4 上午 08:54
 * @Version 1.0
 */
public class BufferedStreamCopyTest {
    /**
     * BufferedInputStream、BufferedOutputStream 複製一張圖片
     */
    @Test
    public void test1(){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File file = new File("mybaby.jpg");
            File file1 = new File("mybabyCopy2.jpg");

            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream(file1);

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            int len;
            byte[] buffer = new byte[1024];
            while ((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }

            System.out.println("若執行到此，表示複製成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bis.close(); //關外層流的時候，就會自動幫你把內層流也關了。(底層需為 先關外層流 後關內層流)
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
