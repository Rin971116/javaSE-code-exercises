package com.set.exer1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/5/15 上午 04:35
 * @Version 1.0
 */
public class Exer1 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();

        list.add(34);
        list.add(34);
        list.add(39);
        list.add(39);
        list.add(51);
        list.add(51);

        List newList = duplicateList(list);
        System.out.println(newList);
    }

    public static List duplicateList(List list){

        //方式1.手寫
//        Object[] arr = list.toArray();
//        HashSet set = new HashSet();
//        for (int i = 0; i < arr.length; i++) {
//            set.add(arr[i]);
//        }
//
//        ArrayList list1 = new ArrayList();
//        for (Object o : set){
//            list1.add(o);
//        }
//
//        return list1;

        //方式2.透過HashSet類、ArrayList類的構造器，讓其自動將List類 ---> HashSet類
        HashSet set = new HashSet(list); //裡面做的事就跟我們上面方式1做的一樣
        ArrayList list1 = new ArrayList(set);
        return list1;
    }
}
