package classloader;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * ClassName:
 * Description:
 *                  可以透過 ClassLoader類對象 調用 getResourceAsStream(String fileName) 建立指定文件的 輸入流
 *                  再調用 Properties類對象的 load(InputStream is) : 處理屬性文件
 *                  所謂的屬性文件就是 將屬性寫入文件中保存，使用 a=b 的格式，意思就是說 屬性 a 的值為 b。
 *                  其實就是 字串 = 字串，的 key = value對
 *                  可以透過這樣的方式來讀取文件內容
 * @Author Rin
 * @Create 2024/6/17 下午 06:38
 * @Version 1.0
 */
public class ClassLoaderTest {
    @Test
    public void test1() throws IOException {
        Properties pros = new Properties();

        // 方式1: 默認路徑為 當前 module 下
//        File file = new File("info.properties");
//        FileInputStream fis = new FileInputStream(file);
//        pros.load(fis);

        // 方式2:
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader(); //獲取ClassLoader類對象
        //透過ClassLoader類對象 獲取文件的讀取流，注意!!!透過 類加載器獲得流 的默認路徑為 當前 module/src 下
        InputStream is = systemClassLoader.getResourceAsStream("info.properties1");

        pros.load(is);

        String name = pros.getProperty("name");
        String password = pros.getProperty("password");
        String password1 = pros.getProperty("password123"); //若沒有對應的屬性，則返回null
        System.out.println(name + ":" + password + ":" + password1);

    }
}
