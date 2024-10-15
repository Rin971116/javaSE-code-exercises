package com.filestream;

import org.junit.Test;

import java.io.*;

/**
 * ClassName:
 * Description:
 *              基礎io流的框架
 *              抽象基類            4個節點流(點到點，也稱文件流)            4個緩衝流(處理流的一種)
 *              InputStream        FileInputStream                      BufferedInputStream
 *              OutputStream       FileOutputStream                     BufferedOutputStream
 *              Reader             FileReader                           BufferedReader
 *              Writer             FileWriter                           BufferedWriter
 *
 * @Author Rin
 * @Create 2024/6/3 上午 09:22
 * @Version 1.0
 */
public class CopyTest {
    /**
     * (字符流)的 讀取、寫入應用: 只能用來操作文本文件，不能操作非文本文件。所以容器使用 char[]
     * 文本文件: .txt, .java, .c, .cpp, .py
     * 非文本文件: .doc, .xls, .jpg, .pdf, .mp3, .mp4, .avi等
     */
    @Test
    public void test1(){
        FileReader fr = null;
        FileWriter fw = null;

        try {
            File file = new File("copySrc.txt");
            File file1 = new File("copyNewFile.txt");
            if (file.exists()){
                file.mkdirs();
            }

            fr = new FileReader(file);
            fw = new FileWriter(file1);

            int len;
            char[] cbuffer = new char[5];
            while ((len = fr.read(cbuffer)) != -1){
                fw.write(cbuffer,0,len); //從cbuffer[0] 寫到 cbuffer[len]
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * (字節流)的 讀取、寫入應用: 讀取字節，容器使用 byte[]
     * 通常拿來操作 非文本文件，但像是要複製的情況下，文本文件也能處理，但還是推薦分的開一點。
     * 文本文件: .txt, .java, .c, .cpp, .py
     * 非文本文件: .doc, .xls, .jpg, .pdf, .mp3, .mp4, .avi等
     */
    @Test
    public void test2(){
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            File file = new File("mybaby.jpg");
            File file1 = new File("mybabyCopy.jpg");

            fis = new FileInputStream(file);
            fos = new FileOutputStream(file1);

            int len;
            byte[] buffer = new byte[1024]; // 1kb，因為使用的是字節流，也就是byte流，改用byte[]來裝
            while ((len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len); //從buffer[0] 寫到 buffer[len]
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
