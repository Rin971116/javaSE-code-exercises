package com.map;

import com.exer1.Characters;
import org.junit.Test;

import java.util.*;

/**
 * ClassName:
 * Description:
 *
 *                  小結:
 *                              Map的常用方法:
 *                                  增:
 *                                      put(Object key, Object value)
 *                                      putAll(Map m)
 *
 *                                  刪:
 *                                      Object remove(Object key): return value
 *
 *                                  改:
 *                                      V put(Object key, Object value): 底層邏輯為若為相同的 key會直接覆蓋掉原有的 value，而外還會返回原本的value
 *                                      putAll(Map m): 沒有返回值
 *
 *                                  查:
 *                                      Object get(Object key): return value
 *                                      boolean containsKey(Object key): 存入的value需重寫equals()、hashcode()
 *                                      boolean containsValue(Object value): 存入的value需重寫equals()
 *                                      boolean isEmpty()
 *                                      boolean equals(Object obj):判斷當前 map和參數對象 obj是否相等
 *
 *                                  插:
 *                                      因為本身無序也就是沒有緊密排列，故也無從插入
 *                                長度:
 *                                      size()
 *                                遍歷:
 *                                      遍歷 key: Set keySet(): return 一個 Set
 *                                      遍歷 value: Collection value(): return 一個 Collection
 *                                      遍歷 entry: Set entrySet(): return 一個 Set
 * @Author Rin
 * @Create 2024/5/16 上午 03:41
 * @Version 1.0
 */
public class HashMapTest {
    @Test
    public void test1(){
        //put(Object key, Object value)
        HashMap map = new HashMap();
        map.put("aa",56);
        map.put("bb",40);
        map.put("cc",30);
        map.put(new Characters("gummy",100),30);

        //Object get(Object key): return value
        Object getValue = map.get("dd"); //若沒有該key，會返回null
        System.out.println(getValue);

        //size()
        System.out.println(map.size());//4

        //Object remove(Object key): return value
        map.remove("aa");
        System.out.println(map);

        // put(Object key, Object value): 跟增加完全一樣，底層邏輯為若為相同的 key會直接覆蓋掉原有的 value
        Object o = map.put("cc",1000);
        System.out.println(map);
        System.out.println(o);

        //putAll(Map m)
        HashMap map2 = new HashMap();
        map2.put("bb",55);
        map2.put("cc",88);
        map2.put("ff",77);
        map.putAll(map2);//沒有返回值

        System.out.println(map);

        //Object get(Object key): return value
        Object value = map.get("bb");
        System.out.println(value);

        //遍歷 key: Set keySet(): return 一個 Set
        Set set = map.keySet();
        //使用跌代器、for-each
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //遍歷 value
        //方式1: Collection value(): return 一個 Collection，底層用的邏輯跟方式2是一樣的，所以其實輸出的value順序是跟keySet()得到的key對應的
        Collection values = map.values();
        for (Object o1 : values){
            System.out.println(o1);
        }

        //方式2: 手寫
        Set set1 = map.keySet();
        for (Object o1 : set1){
            Object o2 = map.get(o1);
            System.out.println(o2);
        }

        //遍歷 entry: Set entrySet(): return 一個 Set
        Set entrySet = map.entrySet();
        //呈現方法1.
        for (Object o1 : entrySet){
            System.out.println(o1);
        }
        //呈現方法2.(精緻版)
        for (Object o1 : entrySet){
            Map.Entry entry1 = (Map.Entry) o1; //強轉成Map接口中聲明的內部接口，好處是可以調用Map.Entry提供的方法
            System.out.println(entry1.getKey() + "------>" + entry1.getValue()); //輸出方式比較靈活
        }
    }
}
