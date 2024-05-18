package com.set.exer2;

import java.util.HashSet;

/**
 * ClassName:
 * Description:
 *              編寫一個程式，獲取10個 1-20 的隨機數，要求隨機數不能重複，並且把最終的隨機數輸出。
 * @Author Rin
 * @Create 2024/5/15 上午 04:50
 * @Version 1.0
 */
public class Exer2 {
    public static void main(String[] args) {
        HashSet set = new HashSet();

        while (set.size() < 10) {
            int random = (int) (Math.random() * 20) + 1;
            set.add(random);

        }
        for (Object o : set){
            System.out.println(o);
        }
    }
}
