package com.Interface;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/4/1 下午 02:37
 * @Version 1.0
 */
public class USBTest {

    public static void main(String[] args) {
        Computer computer = new Computer();

        //方法1.
        computer.dataTransfer(new Camera());
        computer.dataTransfer(new Printer());

        //方法2. 先建立"匿名實現類"的對象，並賦值給usb1，再透過usb1去調用此對象。

        USB usb1 = new USB() { /* 由於USB為接口(沒有構造器，根本不能造對象，也就是實現類)，
                                  這邊理解為在new時，臨時加{}重寫USB中的抽象方法，
                                  JAVA會自動幫我們執行建立一個 "USB的匿名實現類" 的對象並賦值給變數usb1(注意不是某類的匿名對象)，
                                  理論上這邊及時建立的匿名類，就只能在這邊造一次對象，
                                  後面就沒法再透過此類造對象了(畢竟他沒名字，也不知道如何加載此類)。
                               */
            @Override
            public void start() {
                System.out.println("xxx is connect.");
            }

            @Override
            public void end() {
                System.out.println("xxx is disconnect.");
            }
        };
        computer.dataTransfer(usb1);

        //方法3. 方法2的進階版，直接在型參中建立 "匿名實現類" 的 "匿名對象"。
        computer.dataTransfer(new USB() {
            @Override
            public void start() {
                System.out.println("yyy is connect.");
            }

            @Override
            public void end() {
                System.out.println("yyy is disconnect.");
            }
        });
    }
}

interface USB{
    public abstract void start();
    void end();
}

class Computer{
    public void dataTransfer(USB usb){  //argument可以使用接口名，多態的表現(表示型參部分需餵入一個USB的實現類)
        usb.start();
        System.out.println("資料傳輸等執行語句");
        usb.end();
        System.out.println("----------------");
    }
}

class Camera implements USB{ //interface USB 的實現類 (實現關係，而非繼承關係)

    @Override
    public void start() {
        System.out.println("camera connect.");
    }

    @Override
    public void end() {
        System.out.println("camera disconnect.");
    }
}

class Printer implements USB{ //interface USB 的實現類 (實現關係，而非繼承關係)
    @Override
    public void start() {
        System.out.println("Printer connect.");
    }

    @Override
    public void end() {
        System.out.println("Printer disconnect.");
    }
}

