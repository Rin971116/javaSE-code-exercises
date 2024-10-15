package com.otherstream;

import org.junit.Test;

import java.io.*;

/**
 * ClassName:
 * Description:
 *                  PrintStream 打印流，處理流的一種，需要包其他的流
 *                  有點像換皮而已，將一般的輸出流的 write() 換成 println()
 * @Author Rin
 * @Create 2024/6/6 上午 08:01
 * @Version 1.0
 */
public class OtherStreamTest {
    @Test
    public void test1() throws IOException {
        File file = new File("otherstream.txt");
        FileOutputStream fos = new FileOutputStream(file);
        PrintStream ps = new PrintStream(fos);

        //打印到指定文件
        ps.println(123);
        ps.println(456);
        ps.println("測試中文");

        //將sout 的路徑改變
        System.setOut(ps); // 1.先將System類中的out屬性(預設是到控制台的路徑) 替換成新的out，out是一個PrintStream類物件
        System.out.println(789); //原本應該打印至控制台的，現在打印到指定文件去了

        ps.close();

        //若從其他流寫入，一樣會覆蓋掉文件內容
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write("這是從bfferedwriter輸入的測試字串\n");
        bw.write("這是從bfferedwriter輸入的測試字串2");

        bw.close();
    }
}
