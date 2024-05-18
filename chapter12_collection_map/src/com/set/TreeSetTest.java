package com.set;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * ClassName:
 * Description:
 *                  TreeSet底層的數據結構是紅黑數結構，簡單來說就是透過調用存入元素的 compareTo()去比較大小，而非 equals()、哈希值，
 *                  使元素二分法(比較大 or 比較小)來存入TreeSet集合，注意!!若compareTo()返回的結果是一樣大，則被
 *                  TreeSet視作為相同的元素，而 Set具有 元素不可重複性，故不能存入相同的元素。
 *
 *                  存入TreeSet的需求:
 *                                    1.於存入TreeSet的元素的類 需要能夠比較，也就是說要實現 Comparable接口 或 提供comparator實現類給TreeSet構造器
 *                                    2.因為底層是透過compare的方式去存放、查找等，所以存入的所有元素自然要是同一種類的物件，才能比較
 *
 * @Author Rin
 * @Create 2024/5/15 上午 02:53
 * @Version 1.0
 */
public class TreeSetTest {
    @Test
    public void test1(){
        TreeSet set = new TreeSet(); //實現了Comparable接口，因此可以比大小，但同時也只能存入的元素必須全部都是相同的類，不然沒法比較

        set.add("CC");
        set.add("AA");
        set.add("GG");
        set.add("RR");
        set.add("KK");

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next()); //照字母大小順序輸出，有比較過大小
        }
    }

    /**
     * 自然排序
     */
    @Test
    public void test2(){
        TreeSet set = new TreeSet(); //實現了Comparable接口，因此可以比大小，但同時也只能存入的元素必須全部都是相同的類，不然沒法比較

        set.add(new User("gummy",23));
        set.add(new User("brian",24));
        set.add(new User("steven",26));
        set.add(new User("gummy",23)); //compareTo()返回值:0，TreeSet 認為同一個元素
        set.add(new User("baby",23));

        for (Object o : set){
            System.out.println(o);
        }

    }

    /**
     * 定製排序:  透過 TreeSet的構造器 傳入 Comparator的實現類物件
     */
    @Test
    public void test3(){
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) throws ClassCastException{
                if (o1 instanceof User && o2 instanceof User){
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    if (!u1.getName().equals(u2.getName())){
                        return u1.getName().compareTo(u2.getName());
                    }else return u1.getAge() - u2.getAge();
                }
                throw new ClassCastException("類型不匹配");
            }
        };

        TreeSet set = new TreeSet(comparator);

        set.add(new User("gummy",23));
        set.add(new User("brian",24));
        set.add(new User("steven",26));
        set.add(new User("gummy",23)); //compareTo()返回值:0，TreeSet 認為同一個元素
        set.add(new User("baby",23));

        for (Object o : set){
            System.out.println(o);
        }
    }
}
