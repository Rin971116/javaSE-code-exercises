package com.collection;

import com.exer1.Characters;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName:
 * Description:
 *              Java集合框架體系(Java.util包下):
 *              Java.util.Collection(接口):儲存一個一個的數據，(基本上要使用此接口的實現類來存放的物件都要重寫 equals())
 *                  |-----子接口: List:存儲有序的、可重複的數據 ("動態 "數組)
 *                          |----- ArrayList(主要實現類)、LinkedList、Vector(古老、線程安全、已完全被取代)
 *                  |-----子接口: Set:存儲無序的、不可重複的數據 (高中學習的集合的概念)
 *                          |----- HashSet(主要實現類)、LinkedHashSet、TreeSet
 *
 *              Java.util.Map(接口):儲存一對一對的數據(key-value鍵值對，(x1,x2)、(x1,x2) -----> y=f(x),類似於高中的函數)
 *                          |----- HashMap(主要實現類)、LinkedHashMap、TreeMap、Properties、Hashtable(古老、Hashtable(古老、線程安全、已完全被取代)
 *
 *
 *               Collection 接口下的抽象方法:
 *                                          add(Object o)
 *                                          addAll(Collection coll)
 *                                          size()
 *                                          isEmpty(): 是否為空集合?
 *                                          contains(Object obj): 是否包含 obj ?
 *                                          containsAll(Collection coll): 比較是否包含 coll中全部的元素 ?
 *                                          clear(): 清空數組
 *                                          remove(Object o):刪掉指定元素
 *                                          removeAll(Collection coll): 刪除兩個集合的交集(取差集)
 *                                          retainAll(Collection coll): 取兩個集合的交集。返回一個新的集合(取交集)
 *                                          toArray(): 集合 ---> 數組
 *                                          hashcode(): 返回一個 hash值
 *                                          iterator(): 遍歷集合元素

 * @Author Rin
 * @Create 2024/5/10 下午 06:49
 * @Version 1.0
 */
public class CollectionTest {
    /**
     * add(Object o)
     * addAll(Collection coll)
     * size()
     */
    @Test
    public void test1(){
        ArrayList arr1 = new ArrayList();

        //add(Object o):
        arr1.add(123); //auto boxing
        arr1.add(128); //auto boxing
        arr1.add(new String("hello"));
        arr1.add(new Characters("Gummy",100));
        arr1.add(new Characters("Baby",10000));

        System.out.println(arr1);

        //addAll(Collection coll):
        ArrayList arr2 = new ArrayList();
        arr2.add(new Characters("Steven",100));
        arr2.add("world");

        arr1.addAll(arr2); //將arr2的元素一個一個取出來，放進arr1，size() = 7
//        arr1.add(arr2); //將arr2整體視為一份Object放進去arr1，size() = 6

        //size():
        int size = arr1.size();

        System.out.println(arr1);
        System.out.println(size);
    }

    /**
     * isEmpty(): 是否為空集合?
     */
    @Test
    public void test2(){
        ArrayList arr1 = new ArrayList();
        System.out.println(arr1.isEmpty()); //true

        arr1.add(new Characters("Gummy",100));
        System.out.println(arr1.isEmpty()); //false
    }

    /**
     * contains(Object obj): 是否包含 obj ?
     *
     *              調用存入的物件本身的 equals()，因此若欲比較 是否為相同內容物，而非相同地址，則存入的物件需要重寫 equals()，
     *              若未重寫equals()，則調用 Object的equals(): 跟 == 是一樣，比較地址值。
     */
    @Test
    public void test3(){
        ArrayList arr1 = new ArrayList();
        arr1.add(new Characters("Gummy",100));
        boolean contains = arr1.contains(new Characters("Gummy",100));
        //false，因為Characters類中並沒有重寫equals()，所以調用的是Object中的equals()
        System.out.println(contains);

        class Person {
            private String name;
            public Person(String name){
                this.name = name;
            }
            public boolean equals(Object o){
                if (o instanceof Person){
                    Person p = (Person) o;
                    return this.name.equals(p.name);
                }
                return false;
            }
        }

        arr1.add(new Person("Brian"));
        System.out.println(arr1.contains(new Person("Brian"))); //true，因為重寫了Person中的equals()
    }

    /**
     * containsAll(Collection coll): 比較是否包含 coll中全部的元素 ?
     */
    @Test
    public void test4(){
        ArrayList arr1 = new ArrayList();
        arr1.add(128);
        System.out.println(arr1.contains(128));//true，調用的是自動裝箱後，Integer中的equals()
        arr1.add(new Characters());
//        arr1.containsAll();


    }

    /**
     * clear(): 清空數組
     */
    @Test
    public void test5(){
        ArrayList arr1 = new ArrayList();
        arr1.add(123); //auto boxing
        arr1.add(128); //auto boxing
        arr1.add(new String("hello"));
        arr1.add(new Characters("Gummy",100));
        arr1.add(new Characters("Baby",10000));

        System.out.println(arr1.isEmpty());//false
        System.out.println(arr1.size());//5
        arr1.clear();
        System.out.println(arr1.isEmpty());//true
        System.out.println(arr1.size());//0
    }

    /**
     * remove(Object o):刪掉指定元素
     * removeAll(Collection coll): 刪除兩個集合的交集(取差集)
     * retainAll(Collection coll): 取兩個集合的交集。返回一個新的集合(取交集)
     */
    @Test
    public void test6(){
        ArrayList arr1 = new ArrayList();
        arr1.add(123); //auto boxing
        arr1.add(128); //auto boxing
        arr1.add(128); //auto boxing
        arr1.add(new String("hello"));
        arr1.add(new Characters("Gummy",100));
        arr1.add(new Characters("Baby",10000));
        System.out.println(arr1);

        arr1.remove(new Integer(128));//只刪除一個128
        arr1.remove(new Characters("Gummy",100));
        //刪不掉是因為Characters中沒有重寫equals()，調用Object的equals()，判斷沒有相同地址的物件。
        System.out.println(arr1);
    }

    /**
     * toArray(): 集合 ---> 數組
     * Arrays.asList(Object obj): 數組 ---> 集合
     */
    @Test
    public void test7(){
        ArrayList arr1 = new ArrayList();
        arr1.add(123); //auto boxing
        arr1.add(128); //auto boxing
        arr1.add(128); //auto boxing
        arr1.add(new String("hello"));
        arr1.add(new Characters("Gummy",100));
        arr1.add(new Characters("Baby",10000));

        Object[] arr2 = arr1.toArray();
        System.out.println(arr2); //print adress
        System.out.println(Arrays.toString(arr2));

        Integer[] arr3 = new Integer[]{1,2,3};
        List list = Arrays.asList(arr3); //實際返回一個ArrayList類的物件
        System.out.println(list.size()); //3
        System.out.println(list);

        int[] arr4 = new int[]{1,2,3};
        List list1 = Arrays.asList(arr4);
        System.out.println(list1.size());
        //1，因為asList(Object o)，放入的參數必須是物件級別才行，list1整體才能視作一個物件(array類)，int為基本數據類型則不能
        System.out.println(list1);
    }
    /**
     * hashcode(): 返回一個 hash值
     * iterator(): 遍歷集合元素
     */

}
