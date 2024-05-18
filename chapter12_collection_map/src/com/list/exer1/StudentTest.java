package com.list.exer1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/5/14 下午 08:01
 * @Version 1.0
 */
public class StudentTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList students = new ArrayList();

        System.out.println("請輸入學生訊息:");

        while (true){
            System.out.println("1:繼續輸入 ; 0:結束輸入");
            int selection = sc.nextInt();
            if (selection == 0){
                break;
            }

            System.out.println("請輸入學生的姓名:");
            String name = sc.next();
            System.out.println("請輸入學生年齡:");
            int age = sc.nextInt();

            Student s = new Student(name,age);

            students.add(s);
        }

        //遍歷students訊息
        for (Object o : students){
            System.out.println(o);
        }

        sc.close();
    }
}
