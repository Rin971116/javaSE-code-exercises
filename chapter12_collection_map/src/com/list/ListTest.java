package com.list;

import com.exer1.Characters;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ClassName:
 * Description:
 *                              小結:
 *                              List的常用方法:
 *                                    增
 * *                                      add(Object obj)
 * *                                      addAll(Collection coll)
 * *                                  刪
 * *                                      remove(Object obj)
 * *                                      removeAll(Collection coll)
 *                                        remove(int index) *
 * *                                  改
 * *                                      set(int index, Object obj) *
 * *                                  查
 * *                                      get(int index) *
 *                                        indexOf(Object obj) * :return 元素所在位置的 index，若 return負數，代表找不到該元素
 * *                                  插
 * *                                      add(int index, Object obj)
 * *                                      addAll(int index, Collection coll) *
 * *                                  長度
 * *                                      size()
 * *                                  遍歷
 * *                                      iterator()
 * *                                      for-each loop
 *                                        for loop
 *
 * @Author Rin
 * @Create 2024/5/14 下午 05:54
 * @Version 1.0
 */
public class ListTest {
    @Test
    public void test1(){
        List list = new ArrayList();

        //add(Object obj)
        list.add(123);
        list.add(128);
        list.add(new Characters("Gummy",100));
        list.add(2);

        System.out.println(list);

        //remove(int index) *
        list.remove(2); //刪除index[2]的元素，而非 2的Integer類物件
        System.out.println(list); //[123, 128]

        //set(int index, Object obj) *
        list.set(1,new Characters("Gummy",100));
        System.out.println(list);

        //get(int index) *
        System.out.println(list.get(1));

        //indexOf(Object obj) *
        System.out.println(list.indexOf(123)); //0

        //addAll(int index, Collection coll) *
        ArrayList arr1= new ArrayList();
        arr1.add(456);
        arr1.add(789);
        list.addAll(1,arr1); //從index[1]開始插入arr中的所有元素，list原有的元素往後擠
//        list.addAll(2,arr1); //從index[2]開始插入arr中的所有元素，這邊index[2]沒有元素，但不算index越界，相當於一般addALL()的操作
//        list.addAll(3,arr1); //IndexOutOfBoundsException

        System.out.println(list);
        System.out.println("-----------------------");

        //使用跌代器遍歷
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //使用for-each遍歷
        System.out.println("-----------------------");
        for (Object o : list){
            System.out.println(o);
        }


    }
}
