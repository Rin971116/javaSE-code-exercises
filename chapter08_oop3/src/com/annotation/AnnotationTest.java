package com.annotation;

/**
 * ClassName:
 * Description:
 *                  框架 = 注解 + 反射 + 設計模式
 *                  JAVA基礎階段: @Override , @Deprecated , @SuppressWarnings
 *                  元注解: 對現有的注解 進行 注解(增加規定)，
 *                          ex. @Target: 表明可以用來修飾的結構。
 *                              @Retation: 表明生命週期。
 * @Author Rin
 * @Create 2024/4/7 下午 02:50
 * @Version 1.0
 */
public class AnnotationTest {

    public static void main(String[] args) {
        Student student = new Student();
        student.walk(); //Deprecated

    }
}

class Person{
    public void walk(){
        System.out.println("人走路");
    }
}

class Student extends Person{
    @Override
    @Deprecated //表示不推薦使用，但人可使用，在開發新的功能時，能避開就避開
    //@SuppressWarnings() 抑制編譯器警告，白話說就是將 編譯器為了提示而跳出的警告(不影響編譯執行)強制關閉。
    public void walk(){
        System.out.println("學生走路");
    }


}