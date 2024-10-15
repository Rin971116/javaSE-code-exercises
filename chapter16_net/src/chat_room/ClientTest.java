package chat_room;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/6/9 上午 08:16
 * @Version 1.0
 */
public class ClientTest {
    public static void main(String[] args){
        Socket socket = null;
        try {
            //建立一個socket，對到對應的server端
            socket = new Socket("192.168.3.25", 8989);
            //開一個發訊息的線程
            SendMessageThread smt = new SendMessageThread(socket);
            smt.start();

            //開一個接收訊息的線程
            ReceiveMessageThread rmt = new ReceiveMessageThread(socket);
            rmt.start();

            smt.join();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close(); //由於是TCP 協議，三次握手、四次揮手，要斷開之前，也會先問過server端是否一切都傳輸完成，故不會說斷就斷，安全
                //想像成要關之前，會先確認server端是否還有需要用到socket的代碼未執行
                //socket被關閉後，其底層使用的inputStream、outputStream 都會被一併關閉
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

class SendMessageThread extends Thread{
    private Socket socket;
    private String ip;

    public SendMessageThread(Socket socket) {
        this.socket = socket;
        this.ip = socket.getInetAddress().getHostAddress();
    }

    @Override
    public void run() {
        Scanner sc = null;
        PrintStream ps = null;
        try {
            sc = new Scanner(System.in);//System.in是一個inputStream的物件，這意味這它是從某處讀取數據，這邊某處是鍵盤
            OutputStream os = socket.getOutputStream();
            ps = new PrintStream(os);

            while (true){
                System.out.print("你(" + ip + "):");
                String str = sc.nextLine(); //阻塞式方法
//                os.write(str.getBytes()); //寫出去的是 字節

                ps.println(str);

                if ("out".equals(str)){
                    break;
                }
            }
//            ps.println("已離開聊天室");

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
//            ps.close();
//            System.out.println(socket.isClosed());
            sc.close();

        }

    }
}

class ReceiveMessageThread extends Thread{
    private Socket socket;
    private String ip;

    public ReceiveMessageThread(Socket socket) {
        this.socket = socket;
        this.ip = socket.getInetAddress().getHostAddress();
    }

    @Override
    public void run() {
        InputStream is = null;
        Scanner sc = null;
        try {
            is = socket.getInputStream();

            //方式1(錯誤): 接收的是字符，再轉成string，數組要大於傳輸來的字節，不是安全的方式
//            int len;
//            byte[] buffer = new byte[5];
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            while ((len = is.read(buffer)) != -1){
//                baos.write(buffer,0,len);
//                System.out.println(baos);
//            }

            //方式2: sc.nextLine()接收的是string，所以不能讀字符，所以寫入的時候就要是傳string
            sc = new Scanner(is);
            while (sc.hasNextLine()){ //只要對面的輸出流一直開著，這邊的sc.hasNextLine()就會一直是true，以為對方還有東西要寫
                String str = sc.nextLine(); //停在這等，直到收到透過網路到緩存區來的string，!!注意!!接收的是string
                System.out.println(str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            sc.close();
        }
    }
}
