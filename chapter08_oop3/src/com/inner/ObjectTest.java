package com.inner;

/**
 * ClassName:
 * Description:
 *              request:請編寫一個匿名內部類，它繼承Object，並在匿名內部類中聲明一個public void test()打印尚硅谷。
 * @Author Rin
 * @Create 2024/4/3 下午 04:01
 * @Version 1.0
 */
public class ObjectTest {

    public static void main(String[] args) {
        class InnerClass{ // 這是有名的局部內部類
            public void test(){
                System.out.println("尚硅谷");
            }
        }

        InnerClass innerClass = new InnerClass();
        innerClass.test();

        new Object(){ //解讀成建立一個有test()的新的Object類(也就是Object的子類)的"物件"
            public void test(){
                System.out.println("尚硅谷");
            }
        }.test();

        new ObjectTest(){
            public void test(){
                //這邊要解讀成建立一個有test()的新的ObjectTest類的"物件"，
                // 不同於原本的ObjectTest類，重合上述兩點，
                // 不就是等於在new 一個繼承於ObjectTest類的子類，而這個子類多了一個test()方法，
                // 並且這個子類並沒有實際的類名，故是匿名類。
                // 實際的類名應該要完整的設計一個類，例如: class SubObjectTest{}
                System.out.println("這不是ObjectTest類，而是一個有test()的新的ObjectTest類");
            }
        }.test(); //因為是匿名類的匿名對象，必須在創建的當下就直接接著調用，否則之後根本調不了。


        //有加{}就算是C的子類/實現類了，表示在C的基礎上加新屬性OR方法的類，即便{}中啥都沒寫也是告訴JAVA這是一個匿名子類/匿名實現類。
        C changeC = new C(){};
        System.out.println(changeC.getClass());
        System.out.println(changeC.getClass().getSuperclass());
    }
}

class  C{
    public void method1(){
        System.out.println("這是普通類的方法1");
    }
}
