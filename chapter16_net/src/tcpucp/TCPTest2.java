package tcpucp;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ClassName:
 * Description:
 *                  從客戶端傳遞文本、非文本到伺服器端:
 *                                     客戶端: 簡單來說就是先創立socket連接服務器的 ip,port ，然後讀 欲傳輸的 file類物件，再將字節寫至網路的緩存區。
 *                                     服務端: 創立 ServerSocket設定要使用的 port，調用 accept()，獲取客戶端的 socket，再從網路緩存區讀取字節。
 * @Author Rin
 * @Create 2024/6/8 上午 06:59
 * @Version 1.0
 */
public class TCPTest2 {
    @Test
    public void server() throws IOException {
        int port = 9090;
        ServerSocket serverSocket = new ServerSocket(port);

        Socket socket = serverSocket.accept();
        //此時客戶端的資料來了，在緩存區，我們要讀取它，所以需要建立 輸入流 以從緩衝區 讀取某物
        InputStream is = socket.getInputStream();
        File file = new File("mybaby_copy.jpg"); //for local save

        int len;
        byte[] buffer = new byte[5];
        FileOutputStream fos = new FileOutputStream(file); //要 寫 到指定的file中，建立輸出流
        while ((len = is.read(buffer)) != -1){
            System.out.println("讀到了");
            //想像成緩衝區有兩個開口，一邊在放，一邊在拿同步進行，
            //負責放的那邊(客戶端)傳完數據後需要主動把入口關了，server這邊才知道那些就是全部了，不然會以為還有，只是還沒來
            fos.write(buffer);
        }

        System.out.println("執行到此表示複製完畢");

        //傳回給客戶端回饋訊息
        OutputStream os = socket.getOutputStream();
        os.write("嗨，這邊是server端，已收到!! baby超可愛!".getBytes());


        os.close();
        fos.close();
        is.close();
        socket.close();
        serverSocket.close();
    }

    @Test
    public void client() throws IOException {

        //創建客戶端的socket對象
        int port = 9090;
        InetAddress ipAdress = InetAddress.getByName("192.168.3.25");
        Socket socket = new Socket(ipAdress, port);

        //建立目標file對象，以及讀取該文件的輸入流
        File file = new File("mybaby.jpg");
        FileInputStream fis = new FileInputStream(file);

        //通過socket 輸出到 server端，造兩端socket之間的路
        OutputStream os = socket.getOutputStream(); //

        //傳輸數據，先寫到內存的緩衝區 到 透過網卡 發送至網路，所以目的是 建立輸出流，以寫某物到緩衝區
        byte[] buffer = new byte[5];
        int len;
        while ((len = fis.read(buffer)) != -1){
            os.write(buffer,0,len);
            System.out.println("數據已寫至緩衝區");
        }
        //告訴server端，已經沒有要再傳數據了，不用等了，之所以不直接使用socket.close()是因為下面還要使用到socket 接收server端的回饋訊息
        socket.shutdownOutput();
        System.out.println("數據發送完畢");

        InputStream is = socket.getInputStream();
        int len1;
        byte[] buffer1 = new byte[5];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        while ((len1 = is.read(buffer)) != -1){
            baos.write(buffer,0,len1); // 將讀到的字節寫到baos物件中的 byte[]屬性中
        }

        System.out.println(baos.toString());


        //關閉流、socket
        baos.close();
        os.close();
        fis.close();
        socket.close();
    }
}
