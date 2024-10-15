package inetaddress;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * ClassName:
 * Description:
 *                  InetAddress的 實例化方式、常用方法
 * @Author Rin
 * @Create 2024/6/7 上午 02:24
 * @Version 1.0
 */
public class InetAddressTest {
    /**
     *  靜態方法
     *  InetAddress.getByName(String host): 建立一個 InetAddress對象，在java中代表一個 ip地址 對象
     *  InetAddress.getLocalHost(): 獲取本機的 ip位置
     *
     *  非靜態方法
     *  inet1.getHostName(): 獲取域名，若沒有域名則傳回 ip 地址
     *  inet1.getHostAddress(): 獲取ip 地址
     */
    @Test
    public void test1() throws UnknownHostException {
        InetAddress inet1 = InetAddress.getByName("192.168.23.31");
        InetAddress inet2 = InetAddress.getByName("ani.gamer.com.tw");
        System.out.println(inet1);
        System.out.println(inet2);

        InetAddress inet3 = InetAddress.getByName("127.0.0.1"); //也是獲取本機的ip
        InetAddress localInet = InetAddress.getLocalHost();
        System.out.println(localInet);

        String hostName = inet1.getHostName(); //獲取域名，若沒有域名則傳回 ip 地址
        String hostAddress = inet2.getHostAddress(); //獲取ip 地址

        System.out.println(hostName);
        System.out.println(hostAddress);
    }
}
