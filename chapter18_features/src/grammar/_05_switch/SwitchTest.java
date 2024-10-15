package grammar._05_switch;

import org.junit.Test;

import java.util.Scanner;

/**
 * ClassName:
 * Description:
 *                  switch表達式 :
 *                      在 switch結構上，增加了 -> 符號的使用，使用 -> 代替 : 以後，就不需要寫 break;了

 *                  switch的類型匹配 : (在 jdk17 當中還是預覽特性，了解即可)
 *                      在 case 後面放 (類型 變量名)的結構，可以做到 判斷傳入 switch的值是否為該類型的，如果是順便賦值給 後面那個變量名
 *
 * @Author Rin
 * @Create 2024/7/10 下午 08:08
 * @Version 1.0
 */
public class SwitchTest {
    /**
     * 舊的 switch: case X : ... break;
     * case 有所謂的穿透性，若不加 break 就會繼續執行
     */
    @Test
    public void test1() {
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        switch (next) {
            case "A", "a":
                System.out.println("aaa");
                System.out.println("aaaaa");
                break;

            case "B": // 這邊因為沒有加 break; 所以會繼續執行到C 的敘述句
                System.out.println("bbb");
            case "C":
                System.out.println("ccc");
                break;
        }
    }

    /**
     * 新的 switch 特性 :
     * 1.可使用 -> 符號，不用加 break，多行敘述句時需要使用 {} 包
     * 2.使用 yield 可以返回一個值，若只有一行語句可以省略 yield、{}
     * 3.使用 , 符號可以讓 多個選項 共用一個敘述
     * 4.類型匹配，類似 instanceOf (在 jdk17 當中還是預覽特性，了解即可)
     */
    @Test
    public void test2() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String next = sc.next();
            int result = switch (next) {
                case "A" -> {
                    System.out.println("aaa");
                    System.out.println("aaaaa");
                    yield 10;
                }
                case "B", "b" -> {
                    System.out.println("bbb");
                    yield 20;
                }
                case "C" -> {
                    System.out.println("ccc");
                    yield 30;
                }
                case "D" -> 40;
//                case String str :  現版本不能用，功能為 判斷傳進來的next是否instanceOf String，如果是，則賦值給str
//                    yield "String:" + str;

                default -> throw new IllegalStateException("Unexpected value: " + next);
            };

            System.out.println(result);
        }

    }

}
