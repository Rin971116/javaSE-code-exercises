package com.method;

import java.io.PrintStream;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/8 下午 10:27
 * @Version 1.0
 */
public class MethodExer {
    public static void main(String[] args) {
        int a = 10;
        int b = 10;
        method(a,b); //調用method()後，僅打印出 a = 100, b = 200，請寫出method()
        System.out.println("a ="+a);
        System.out.println("b ="+b);
        System.out.println("123");
        System.out.println("a ="+10);
        System.out.println("a =10");
        System.out.println("a =20");
        System.out.println(123);
        //以上不管哪種都是傳入string類的型參，所以呼叫的方法是println(String str)，
        // 只有最後一種為傳入int類型的型參，因此他呼叫的方法是println(int i)，因此他不會呼叫到override的println(String str)版本
    }

    public static void method(int a, int b){
        PrintStream ps = new PrintStream(System.out){
            @Override
            public void println(String x){

                if ("a =10".equals(x)){
//                    x = "a =100";
                    super.println("a =100");
                } else if ("b =10".equals(x)) {
//                    x = "b =200";
                    super.println("b =200");
                }
                super.println(456);//這邊是呼喚父類別的println()，也就是原版的println()
            }
        }; //未搞懂，如何讓18,19行讀到的System.out.println()是override的版本?
        System.setOut(ps); //重點應該是這邊32,35行 如何把override的版本傳出去給main()
    }
}
