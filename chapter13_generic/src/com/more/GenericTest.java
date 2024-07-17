package com.more;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName:
 * Description:
 *                  ?通配符的使用 :
 *                                  ?的使用:
 *                                      以集合為例: 可以讀取數據，不能寫入數據 (例外: null)
 *                                  ? extends A
 *                                      以集合為例: 可以讀取數據，不能寫入數據 (例外: null)
 *                                  ? super A
 *                                      以集合為例: 可以讀取數據，可以寫入A類型 或 A類的子類 的數據 (例外: null)
 * @Author Rin
 * @Create 2024/5/26 下午 08:36
 * @Version 1.0
 */
public class GenericTest {

    public static <E> ArrayList<E> changeElement(E[] e, int index1, int index2){
        E temp = e[index1];
        e[index1] = e[index2];
        e[index2] = temp;

        List<E> list = Arrays.asList(e);
        ArrayList<E> list1 = new ArrayList<>();
        list1.addAll(list);
        return list1;
    }
    @Test
    public void test1(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(123);
        list.add(456);
        list.add(789);
        ArrayList<Object> newList = GenericTest.changeElement(list.toArray(), 0, 2);
        for (Object o : newList){
            System.out.println(o);
        }

    }
    @Test
    public void test2(){
        ArrayList<Object> list = new ArrayList<>();

        ArrayList<?> list1 = new ArrayList<>();
        list1 = list;
//        list1.add(123); 指定存放?類型的集合，無法增加確定你限制的類型為何，故無法讓你存入

        ArrayList list2 = new ArrayList();
        list2 = list;
        list2.add(123);

        ArrayList<?> list3 = new ArrayList<>();
        list1 = list3;

    }
    @Test
    public void test3(){
        ArrayList<Object> list = new ArrayList<>();

        ArrayList<?> list1 = new ArrayList<>();
        ArrayList<Father> list2 = new ArrayList<>();
        ArrayList<Son> list22 = new ArrayList<>();

        ArrayList<? extends Father> list3 = new ArrayList<>();
//        list3.add(new Object());
//        list3.add(new Father());
//        list3.add(new Son());
        list3.get(0); //可以讀取

//        list = list3; 報錯
        list3 = list2;
//        list3 = list22; 報錯


        ArrayList<? super Father> list4 = new ArrayList<>();
//        list4.add(new Object());
        list4.add(new Father()); // 可以添加Father類物件
        list4.add(new Son()); // 可以添加Father類的子類物件
        list4.get(0); //可以讀取

//        list = list4; 報錯
        list4 = list2;
//        list4 = list22; 報錯
    }
}
