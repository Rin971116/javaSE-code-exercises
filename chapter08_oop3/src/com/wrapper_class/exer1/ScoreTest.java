package com.wrapper_class.exer1;

import java.util.Scanner;
import java.util.Vector;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/4/8 下午 03:12
 * @Version 1.0
 */
public class ScoreTest {
    public static void main(String[] args) {
        Vector v = new Vector();

        Scanner sc = new Scanner(System.in);
        int maxScore = 0;

        while (true){
            System.out.print("請連續輸入學生成績(輸入負數時停止):");
            int score = sc.nextInt();
            if (score >= 0){
                v.addElement(score); //將int 類型餵入 Object的型參，過程為int自動封箱成Intrger，在餵入Object，同時為多態的體現。

                if (score > maxScore){
                    maxScore = score;
                }
            }else
                break;
        }


        for (int i = 0; i < v.size(); i++) {

            // 方式1. jdk5.0前
//            Integer integerV = (Integer) (v.elementAt(i));
//            int scoreInt = integerV.intValue();

            // 方式2. 有自動封箱/拆箱後，遇到int、Integer都是可以互相直接賦值的，過程會自動封箱/拆箱。
            int scoreInt = (Integer) (v.elementAt(i)); // Object ---(強轉)---> Integer ---(自動拆箱)---> int

            int scoreDiff = maxScore - scoreInt;
            char grade = ' ';
            if (scoreDiff <= 10){
                grade = 'A';
            } else if (scoreDiff <= 20) {
                grade = 'B';
            }else if (scoreDiff <= 30){
                grade = 'C';
            }else {
                grade = 'D';
            }

            System.out.println("student " + i + " score is " + v.elementAt(i) + " grade is " + grade);

        }
        System.out.println("最高分: " + maxScore);

        sc.close();

    }
}
