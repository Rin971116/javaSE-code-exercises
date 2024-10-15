package url;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * ClassName:
 * Description:
 *                  URL的格式:
 *                      範例: "http://127.0.0.1:8080/examples/abcd.jpg?name=Tom"
 *                            應用層協議 ip地址  port  資源地址           參數列表
 *
 *                  演示 如何從 url獲取資源。
  * @Author Rin
 * @Create 2024/6/13 下午 06:21
 * @Version 1.0
 */
public class URLTest {
    @Test
    public void test1() throws IOException {
        //1. 獲取url實例
        String str = "http://127.0.0.1:8080/examples/abcd.jpg"; //尚硅谷的範例url，我並沒有將我的電腦起成伺服器
        URL url = new URL(str);

        //2. 建立與服務器端的連接，很像客戶端new socket的概念，目的是連接上目標url，不同在於一旦接上後，url已經發送資料到緩存區了，去讀取就行
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        //3. 讀取數據
        InputStream is = urlConnection.getInputStream(); // 讀取網路緩存區來的資料，url ---> 內存

        //4. 將數據寫至指定位置
        File file = new File("dest.jpg");
        FileOutputStream fos = new FileOutputStream(file);

        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1){
            fos.write(buffer,0,len);
        }
        System.out.println("文件下載完成");

        fos.close();
        is.close();
        urlConnection.disconnect(); //就是close()的意思
    }
}
