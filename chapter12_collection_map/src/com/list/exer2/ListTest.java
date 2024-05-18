package com.list.exer2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/5/14 下午 08:15
 * @Version 1.0
 */
public class ListTest {
    public static void main(String[] args) {

        //1.隨機生成30個字符，並存入指定的ArrayList中
        ArrayList arr1 = new ArrayList();
        for (int i = 0; i < 30; i++) {
            double random = Math.random() * 25 + 1;
            char randomLetter = (char) (97 + random);
//            String randomLetter = new String()
            arr1.add(randomLetter); //char自動封裝成Character類物件
        }
        System.out.println(arr1);

        System.out.println("b出現的次數:" + listTest(arr1, 'b'));
        System.out.println("a出現的次數:" + listTest(arr1,'a'));
        System.out.println("y出現的次數:" + listTest(arr1,'y'));

    }

    //2.遍歷ArrayList，查找指定元素出現次數
    public static int listTest(Collection coll, Character s){
        int times = 0;
        Iterator iterator = coll.iterator();

        while (iterator.hasNext()) {

            if (s.equals(iterator.next())) {
                System.out.println("執行一次");
                times++;
            }

        }

        return times;
    }
}
