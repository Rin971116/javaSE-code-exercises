package tcpucp;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/6/7 下午 01:17
 * @Version 1.0
 */
public class TCPTest {
    @Test
    public void server() {

        Socket socket = null;
        InputStream is = null;
        try {

            // 1.創建ServerSocket
            int port = 8989;
            ServerSocket ss = new ServerSocket(8989);

            // 2.調用accept()，接收客戶端的Socket，類似於啟動，進入等待狀態
            socket = ss.accept();  //阻斷式方法，停在這邊等，直到接收到客戶端發的請求，則返回客戶端的Socket對象
            System.out.println("服務端已開啟");
            System.out.println("收到了來自:" + socket.getInetAddress().getHostAddress() + "的連接");

            // 3.開啟輸入流，接收數據 (建立輸入流 = 為了讀取 某物 到內存)
            is = socket.getInputStream();  //獲取一個讀socket(客戶端的Socket)內容的 字節流 對象實例
            int len;
            //錯誤的方式: 這邊是因為 byte[1024]大於客戶端傳來的字符數量，所以打印時才不會出現亂碼
//            byte[] buffer = new byte[1024];
//            while ((len = is.read(buffer)) != -1){
//                String str = new String(buffer,0,len);
//                System.out.println(str);
//            }

            //正確的方式: 多建立一個輸出流，先將讀到的buffer寫到某處，這邊用的是ByteArrayOutputStream，預設是寫到其 對象內部的byte[]屬性中
            ByteArrayOutputStream baos = new ByteArrayOutputStream(); //建立輸出流 = 欲傳輸某內容到某位置

            byte[] buffer = new byte[5];
            while ((len = is.read(buffer)) != -1){
                baos.write(buffer,0,len);
            }

            System.out.println(baos.toString()); //全部寫完後，再將 ByteArrayOutputStream 內部byte[]轉成string打印出來


            System.out.println("執行到此的話，表示有成功連接上");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            //關閉Socket
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            //關閉流
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void client() throws IOException {

        //建立socket對象(建立一個對應的插座的概念，兩端需要長一樣，才能成功匹配的概念)
        String ipAddress = "192.168.3.25"; //對方(欲連接方) 的ip address
//        InetAddress ipAdress = InetAddress.getByName("192.168.3.25"); 也可以
        int port = 8989; //對方(欲連接方) 設定的port

        // 將ip,port封裝成對象 這一步，ServerSocket.accept()就通過了，代表這一刻開始就已經接上了，
        // 正確來說是 server端就獲取到了 來自客戶端的這份socket物件
        Socket socket = new Socket(ipAddress, port);

        //建立一個輸出流，傳輸數據 (其實就是兩端同時都拿著 同一個物件，也就是上面那一份socket)
        OutputStream os = socket.getOutputStream(); //要輸出(寫)某內容
        os.write("你好，我來自客戶端".getBytes()); //參數只能放byte[]，因為是字節流，所以要將string轉成對應的byte[]

        //關閉流、socket
        socket.close();
        os.close();
    }
}

