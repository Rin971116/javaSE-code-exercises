package lambda;

import org.junit.Test;

/**
 * ClassName:
 * Description:
 *                  使用 Lambda表達式的大前提:
 *                                  1.使用場景為簡化: 為"只有一個抽象方法 需要實現的 接口" 新建匿名實現類的 實例對象。
 *                                          ex. Comparator，這類接口 統稱 函數式接口，可以使用註解 @FunctionalInterface，加以驗證
 *                  格式規則:
 *                                  正常寫法: 接口名 變數名 = new 接口名(){
 *                                                                      @Override
 *                                                                      public void method1(Xxx a, Yyy b) {...方法體...}
 *                                                                    }
 *
 *                              Lambda表達式: 接口名 變數名 = (Xxx x, Yyy b) -> {...方法體...} 。
 *
 *                              理解: 你看嘛，只能用在只有一種抽象方法的接口上，因為只有一種，所以很多東西都能省略，編譯器也能自行推斷出來，
 *                                    像是 權限修飾、返回值、方法名、甚至如果有使用 唯一泛型當作方法所需參數的話，連型參那部份都可以省了。
 *                                    另外 若方法體 只有單一語句的話，還可以連{}也省了，跟 if()那些一樣，老規則了
 * @Author Rin
 * @Create 2024/6/28 下午 06:29
 * @Version 1.0
 */
public class LambdaText {
    @Test
    public void test1(){
        MyFuctionalInterface mfi = new MyFuctionalInterface() {
            @Override
            public void method1() {
                System.out.println("普通方法");
            }
        };

        //lambda expression
        MyFuctionalInterface mfi1 = () -> System.out.println("test lambda expression.");
        mfi1.method1();
    }

    @Test
    public void test2(){
        MyFuctionalInterface1<String> mfi = (String s1, String s2) -> System.out.println(s1 + s2);
        mfi.method1("abc",",123!!");
    }
}
