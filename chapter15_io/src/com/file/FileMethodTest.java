package com.file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * ClassName:
 * Description:
 *
 *       獲取文件、基本訊息功能:
 *              public String getName(): 獲取名稱
 *              public String getPath(): 獲取路徑
 *              public String getAbsolutePath(): 獲取絕對路徑
 *              public File getAbsoluteFile(): 獲取絕對路徑的 File類實例物件
 *              public String getParent(): 獲取絕對路徑的上層路徑，若沒有，則返回 null，透過 內部的String屬性去調
 *              public long length(): 獲取文件的字節數，不能獲取目錄的長度
 *              public long lastModified(): 獲取最後一次修改的時間(時間戳)
 *
 *      獲取全部文件、文件名稱功能:
 *              public String[] list()
 *              public File[] listFiles()
 *
 *      重新命名功能:
 *              public boolean renameTo(File dest): 將 file1 改名為 參數傳入的 file2的名稱，使用條件須 file1是實際存在
 *                                                                                               file2則不能存在，否則更改後就重名了
 *                                                                                               file2的parent要真實存在，否則找不到
 *                                                                                               ，也不能幫你創建檔案夾
 *      判斷功能:
 *              public boolean exists()
 *              public boolean isDirectory()
 *              public boolean isFile()
 *              public boolean canRead()
 *              public boolean canWrite()
 *              public boolean isHidden()
 *
 *      創建、刪除功能:
 *              public boolean createNewFile(): 創建文件，若文件存在，則不創建，返回 false
 *              public boolean mkdir(): 創建文件目錄(檔案夾)，若上層目錄不存在，則不創建
 *              public boolean mkdirs(): 創建文件目錄(檔案夾)，若上層目錄不存在，則連同上層 都創建
 *              public boolean delete(): 注意!java中的刪除 是永久刪除，不會到資源回收桶，並且要刪除一個檔案夾，其目錄內不能包含其他內容
 *
 * @Author Rin
 * @Create 2024/5/30 上午 04:31
 * @Version 1.0
 */
public class FileMethodTest {
    /**
     * 該文件實際上 不存在的情況下
     */
    @Test
    public void test1() {
        File file = new File("hello.txt");//相對路徑，對單元測試方法來說，其絕對路徑為
        System.out.println(file.getName()); // hello.txt
        System.out.println(file.getPath()); // hello.txt
        System.out.println(file.getAbsolutePath()); // D:\Code\JavaSECode\chapter15_io\hello.txt
        System.out.println(file.getAbsoluteFile()); // D:\Code\JavaSECode\chapter15_io\hello.txt
        System.out.println(file.getParent()); //null，因為該file對象，內部存的路徑string為hello.txt
        System.out.println(file.getAbsoluteFile().getParent()); // D:\Code\JavaSECode\chapter15_io
        System.out.println(file.length()); // 0
        System.out.println(file.lastModified()); // 0
    }

    /**
     * 該文件實際 存在的情況下
     */
    @Test
    public void test2() {
        File file = new File("abc.txt");//相對路徑，對單元測試方法來說，其絕對路徑為
        System.out.println(file.getName()); // abc.txt 
        System.out.println(file.getPath()); // abc.txt
        System.out.println(file.getAbsolutePath()); // D:\Code\JavaSECode\chapter15_io\abc.txt
        System.out.println(file.getAbsoluteFile()); // D:\Code\JavaSECode\chapter15_io\abc.txt
        System.out.println(file.getParent()); //null，因為該file對象，內部存的路徑string為abc.txt
        System.out.println(file.getAbsoluteFile().getParent()); // D:\Code\JavaSECode\chapter15_io
        System.out.println(file.length()); // 10
        System.out.println(file.lastModified()); // 1717017109722
    }

    /**
     * public String[] list()
     * public File[] listFiles()
     * public boolean renameTo(File dest)
     */
    @Test
    public void test3() {
        //public String[] list()
        File file = new File("D:\\io_test");
        String[] filesName = file.list();
        for (String fileName : filesName) {
            System.out.println(fileName);
        }

        //public File[] listFiles()
        File[] files = file.listFiles();
        for (File file1 : files) {
            System.out.println(file1);
        }

        //public boolean renameTo(File dest)
        for (File file1 : files) {
            //將file1的檔案名改成"D:\\file_test\\aa" + file1.getName()
            file1.renameTo(new File("D:\\io_test\\aa" + file1.getName()));
        }
    }

    @Test
    public void test4(){
        File file = new File("D:\\");
        File[] files = file.listFiles();
        for (File file1 : files){
            System.out.println(file1);
        }
    }

    /**
     * public boolean createNewFile()
     * public boolean delete()
     * @throws IOException
     */
    @Test
    public void test5() throws IOException {
        //public boolean createNewFile()
        File file = new File("D:\\io_test\\newHello.txt");
        if (file.createNewFile()){
            System.out.println("創建成功");
        }else {
            System.out.println("該文件已存在，創建失敗");
        //public boolean delete()
            System.out.println(file.delete()? "將其刪除成功" : "將其刪除失敗");
        }
    }

    /**
     * public boolean mkdir()
     * public boolean mkdirs()
     */
    @Test
    public void test6(){
        //public boolean mkdir()
        File file = new File("D:\\io_test\\io3\\io4");
        file.mkdir(); //只負責創建io4，但沒有io3，所以不創建，返回false

        //public boolean mkdirs()
        File file1 = new File("D:\\io_test\\io5\\io6");
        file1.mkdirs(); //創建以上完整路徑，少誰都沒差，一併幫你創建
    }
}
