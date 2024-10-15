package tcpucp;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**
 * ClassName:
 * Description:
 *              UDP傳輸 特點在於 不可靠，不安全，但效率較高； 透過傳輸 數據包(64kb以內)，若超過64kb則使用多個數據包
 *
 *                      發送端可以不管 server端 是否存在 或 已開啟，只管發送包裝好的 DatagramPacket就對了，不論其有沒有接收到，都不會報錯
 *
 *                      端點使用:  DatagramSocket ds = new DatagramSocket(); //客戶端不用填port，server端要設定port
 * @Author Rin
 * @Create 2024/6/12 下午 06:45
 * @Version 1.0
 */
public class UDPTest {
    @Test
    public void sender() throws IOException {
        DatagramSocket ds = new DatagramSocket(); //客戶端不用填port，server端要設定port

        InetAddress ip = InetAddress.getByName("127.0.0.1");
//        byte[] buffer = new byte[1024 * 64];
        byte[] buffer = "這是一個來自客戶端的測試".getBytes();
        int port = 9090;

        //提供一個DatagramPacket 來接收數據，從網路緩存區，其實是放在dp內部的一個byte[]，dp本身做的是將容器byte[]、目標ip、目標port封裝在一個物件
        DatagramPacket dp = new DatagramPacket(buffer,0,buffer.length,ip,port);

        ds.send(dp);

        ds.close();
    }

    @Test
    public void receiver() throws IOException {
        DatagramSocket ds = new DatagramSocket(9090);

        byte[] buffer = new byte[1024 * 64];

        //提供一個DatagramPacket 來接收數據，從網路緩存區，其實是放在dp內部的一個byte[]，dp本身做的是將容器byte[]、目標ip、目標port封裝在一個物件
        DatagramPacket dp = new DatagramPacket(buffer,0,buffer.length);

        //接收數據，放在提供的dp裡面
        ds.receive(dp);

//        讀取數據:
//            dp.getData():獲取dp內部的byte[]
//            dp.getLength():獲取dp內部byte[]的實際元素長度  (len的概念)
        String str = new String(dp.getData(),0,dp.getLength());

        System.out.println(str);

        ds.close();
    }
}
