package com.iterator;

import com.exer1.Characters;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * ClassName:
 * Description:
 *              Iterator跌代器
 *              集合物件透過調用iterator()獲取 Iterator的一份對應當前集合的物件 (跌代器)
 * @Author Rin
 * @Create 2024/5/14 上午 04:56
 * @Version 1.0
 */
public class IteratorTest {
    @Test
    public void test1(){
        ArrayList arr1 = new ArrayList();
        arr1.add(123); //auto boxing
        arr1.add(128); //auto boxing
        arr1.add(128); //auto boxing
        arr1.add(new String("hello"));
        arr1.add(new Characters("Gummy",100));
        arr1.add(new Characters("Baby",10000));

        Iterator iterator = arr1.iterator();//透過集合中的iterator()獲取對應該集合的一份Iterator物件
        while(iterator.hasNext()){
            System.out.println(iterator.next());
            //每調用一次next() iterator中的對應指針下移，並返回集合中對應的元素。
            // (可想像成一個變數的值從0開始，每調用一次next()，該變數++)
        }

        for (Object object : arr1){
            System.out.println(object);
        }


    }
}
