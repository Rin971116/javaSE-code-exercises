package com.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.TreeMap;

/**
 * ClassName:
 * Description:
         Java集合框架體系(Java.util包下):
*                            Java.util.Collection(接口):儲存一個一個的數據，(基本上要使用此接口的實現類來存放的物件都要重寫 equals())
*                                |-----子接口: List:存儲有序的、可重複的數據 ("動態 "數組)
*                                        |----- ArrayList(主要實現類)、LinkedList、Vector(古老、線程安全、已完全被取代)
*                                |-----子接口: Set:存儲無序的、不可重複的數據 (高中學習的集合的概念)
*                                        |----- HashSet(主要實現類)、LinkedHashSet、TreeSet
*
*                            Java.util.Map(接口):無序的儲存一對一對的數據(key-value鍵值對，(x1,x2)、(x1,x2) -----> y=f(x),類似於高中的函數)
*                                        |----- HashMap(主要實現類): 線程不安全，可添加null，底層使用數組+單向鏈表+紅黑樹結構存儲。
 *                                              |----- LinkedHashMap: HashMap使用之結構基礎上，增加一對雙向鏈表，用於紀錄元素添加的先後順序，
 *                                                                    進而在我們遍歷時，能夠按添加的順序顯示，
 *                                                                    開發中，頻繁的遍歷操作，建議使用此類
 *                                       |----- TreeMap
 *                                       |----- Properties
 *                                       |----- Hashtable(古老、線程安全、已完全被取代): 不允許存放null
 *
 *
 *                           Map中 key-value對的特點: 一個 key只能指向一個 value，所以 key具有不可重複，且具有無序性，底層是使用一個 Set
 *                                                  不同 value的值 是可以相同的，所以 value可以重複，但也具有無序性，只能算一個 Collection
 *
 *                                                  Map中有一個屬性為 Entry: 每對 key + value，合起來就稱為一個 Entry，
 *                                                  一個 Entry = 一對 key-value，
 *                                                  多個 Entry 也就是一個無序的、且不可重複(因為每個 Entry中的 key一定不同)，也是一個 Set
 *
 *                           欲存入key、value的物件需求:
 *                                                  欲存入key 中的元素，因為底層使用的是 Set，需重寫 hashcode()、equals()
 *                                                  欲存入value 中的元素，因為底層使用的是 Collection，需重寫 equals()，
 *                                                  Collection的常用方法底層都是透過equals()去比較的。
 *
 *                           !!小結 : 少寫會出事，多寫卻不會有問題，所以以後但凡要使用集合來存取的物件，不論是 Collection或 Map中的任一種，
 *                                   大可將其 hashcode()、equals()全重寫。
 *
 *
 *
 *                           Map的常用方法:
 *  *                                  增:
 *  *                                      put(Object key, Object value)
 *  *                                      putAll(Map m)
 *  *
 *  *                                  刪:
 *  *                                      Object remove(Object key): return value
 *  *
 *  *                                  改:
 *  *                                      put(Object key, Object value): 跟增加完全一樣，底層邏輯為若為相同的 key會直接覆蓋掉原有的 value
 *  *                                      putAll(Map m)
 *  *
 *  *                                  查:
 *  *                                      Object get(Object key): return value
 *  *                                      boolean containsKey(Object key): 存入的value需重寫equals()、hashcode()
 *  *                                      boolean containsValue(Object value): 存入的value需重寫equals()
 *  *                                      boolean isEmpty()
 *  *                                      boolean equals(Object obj):判斷當前 map和參數對象 obj是否相等
 *  *
 *  *                                  插:
 *  *                                      因為本身無序也就是沒有緊密排列，故也無從插入
 *  *                                長度:
 *  *                                      size()
 *  *                                遍歷:
 *  *                                      遍歷 key: Set keySet(): return 一個 Set
 *  *                                      遍歷 value: Collection value(): return 一個 Collection
 *  *                                      遍歷 entry: Set entrySet(): return 一個 Set
 *
 *
 *
 * @Author Rin
 * @Create 2024/5/15 下午 08:55
 * @Version 1.0
 */
public class MapTest {
    /**
     * 因为HashMap的键（key）是基于哈希表实现的，它可以存放任意类型的对象作为键，但在实际使用中，通常将字符串作为键来使用。
     * 使用字符串作为键时，可以方便地进行查找和操作。
     */
    @Test
    public void test1(){
        HashMap map = new HashMap();

        //put(Object key, Object value): 增加一對key-value 元素，相當於Collection 的 add()
        map.put(null,null); //允許存放null
        map.put("aa",12);
        map.put("林",25);
        map.put("陳",25);
        System.out.println(map);
    }

    @Test
    public void test2(){
        Hashtable map = new Hashtable();
        map.put(null,null); //不允許存放null
        map.put(null,"gummy"); //不允許存放null
        map.put("gummy",null); //不允許存放null

        System.out.println(map); //NullPointerException
    }

    @Test
    public void test(){
        TreeMap map = new TreeMap();
//        map.put(null,null); //NullPointerException
        map.put("aa",123);
        map.put("bb",123);
        System.out.println(map);
    }
}

