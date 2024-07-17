package com.use.exer1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/5/22 上午 05:33
 * @Version 1.0
 */
public class Exer1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
//        int random = (int) (Math.random() * 100);
        list.add((int) (Math.random() * 100));
        list.add((int) (Math.random() * 100));
        list.add((int) (Math.random() * 100));
        list.add((int) (Math.random() * 100));
        list.add((int) (Math.random() * 100));

        for (int value : list) {
            System.out.println(value);
            //錯誤方法，因為當遍歷到一半，某元素被remove的話，則list的index就改變了，用for-each會出錯
//            if (i % 2 == 0){
//                list.remove(i);
//            }
        }

        //正確的方式: 使用removeIf()，remove list中，value % 2 == 0 返回true的元素
        list.removeIf(new Predicate<Integer>() {
            @Override
            public boolean test(Integer value) {
                return value % 2 == 0; //return boolean值
            }
        });

        System.out.println("刪除偶數元素後");
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
