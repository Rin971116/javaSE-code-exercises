package chat_room;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/6/9 上午 08:17
 * @Version 1.0
 */
public class ServerTest {
    //處理同步數據方法1.
//    private static int memberCount;
//    public static synchronized void addMemberCount(){
//        memberCount++;
//    }
//    public static synchronized void minusMemberCount(){
//        memberCount--;
//    }

    //處理同步數據方法2: 使用AtomicInteger類，以及該類的方法
    private static AtomicInteger memberCount = new AtomicInteger(0);

    public static void addMemberCount() {
        memberCount.incrementAndGet();
    }

    public static void minusMemberCount() {
        memberCount.decrementAndGet();
    }

    public static int getMemberCount() {
        return memberCount.get();
    }
    public static void main(String[] args){
        ArrayList<Socket> sockets = new ArrayList<>();
        ServerSocket serverSocket = null;
        try {
            int port = 8989;
            serverSocket = new ServerSocket(port);
            System.out.println("伺服器已啟動");

            while (true) {
                Socket socket = serverSocket.accept(); //會停在這等有客戶端建立對應的socket
                sockets.add(socket);

                ChatRoomThread crt = new ChatRoomThread(socket,sockets);
                crt.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ChatRoomThread extends Thread{
    private Socket socket;
    private String ip;
    private ArrayList<Socket> sockets;

    public ChatRoomThread(Socket socket, ArrayList<Socket> sockets) {
        this.socket = socket;
        ip = socket.getInetAddress().getHostAddress();
        this.sockets = sockets;
    }

    @Override
    public void run() {
        Scanner sc = null;
        try {
            ServerTest.addMemberCount();
            sendToOther(ip + "已加入聊天室");

            InputStream is = socket.getInputStream(); //從緩存區獲取字節

            //方式1(錯誤): 數組要大於傳輸來的字節，不是安全的方式
//            int len;
//            byte[] buffer = new byte[1024];
//            while ((len = is.read(buffer)) != -1){
//                String str = new String(buffer,0,len);
//                System.out.println(str);
//            }

            //方式2"
            sc = new Scanner(is); //從is的路徑讀取，而is是從緩存區讀取
            while (sc.hasNextLine()){
                String str = sc.nextLine(); //!!注意!!接收的是string
                if (("out").equals(str)){
                    sockets.remove(socket);
                    ServerTest.minusMemberCount();
                    break;
                }
                sendToOther(ip + ":" + str);
            }

            sendToOther(ip + "已離開聊天室");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendToOther(String str) throws IOException {
        for (Socket everySocket : sockets){
            OutputStream os = everySocket.getOutputStream();
//            os.write(str.getBytes()); //寫出去的是 字節
            PrintStream ps = new PrintStream(os);
            ps.println(str); //用打印流包的目的在於 想使用println()，可以直寫寫入string
//            ps.close();
//            System.out.println(everySocket.isClosed());
        }
    }

}
