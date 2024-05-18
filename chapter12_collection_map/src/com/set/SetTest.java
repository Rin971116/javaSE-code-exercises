package com.set;

import com.exer1.Characters;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName:
 * Description:
 *              Java.util.Collection(接口):儲存一個一個的數據，(基本上要使用此接口的實現類來存放的物件都要重寫 equals())
 *  *                  |-----子接口: List:存儲有序的、可重複的數據 ("動態 "數組)
 *  *                          |----- ArrayList(主要實現類)、LinkedList、Vector
 *  *                  |-----子接口: Set:存儲無序的、不可重複的數據 (高中學習的集合的概念)
 *  *                          |----- HashSet(主要實現類)
 *                                      |----- LinkedHashSet: 在HashSet使用之結構基礎上，增加一對雙向鏈表，用於紀錄元素添加的先後順序，
 *  *                                                         進而在我們遍歷時，能夠按添加的順序顯示，
 *  *                                                         開發中，頻繁的遍歷操作，建議使用此類
 *                             |----- TreeSet
 *
 *
 * --------------------以下規則特性只適用於 HashSet、以及其子類，注意!! TreeSet不適用-----------------------------------------------
 *
 *                      Set: 主要使用場景在於 不可存入重複的數據時，何謂相同的數據 ? 也就是equals()為true的物件，
 *                             存入元素時，底層邏輯是透過每個物件的哈希值(相當於另一個equals()的概念，兩物件內容相等，則哈希值也會相同)，
 *                             經過運算後，決定要存放的位置(無序，並不是隨機)，算法是固定的，所以相同的元素就一定會指向放在同個位置
 *                             那反正都是通過equals()來比，那為何還需要有hashcode的存在?
 *                                因為透過哈希值可以解決Set集合在判斷是否已存入相同元素時，因沒有順序(index)，只能從頭一個一個去比較equals()，
 *                                效率太差，多一個哈希值的比較，相當於多了一個判別依據
 *                                     第一步: 可以先透過物件的哈希值(基本上獨一無二)帶入一些計算 得到對應存放位置，若沒有元素存放，則直接存放
 *                    若該位置已有人存放，第二步: 再透過比對哈希值，判別是否為相同元素
 *                       若哈希值也相同，第三步: 再透過equals()判別是否為相同元素(基本上哈希值相同，但equals()不同的可能性幾乎為0)
 *                                    第四部: 若結果不相同，再存入，存放在同個位置(同個單向鍊表中)
 *
 *                       !!存入HashSet、LinkHashSet 的要求:
 *                                      需重寫欲存入之元素類的 equals()、hashCode()
 * @Author Rin
 * @Create 2024/5/15 上午 01:31
 * @Version 1.0
 */

public class SetTest {
    @Test
    public void test1(){
        Set s = new HashSet();
        s.add(123);
        s.add(128);
        s.add(128); //相同的元素不會報錯，直接不存入
        s.add(new Characters("gummy",100));
        s.add(new Characters("gummy",100)); //錯誤示範: 重複存入，因為Characters類沒有重寫hashCode()
        s.add(new Characters("baby",10000));


        System.out.println(s);
        //[128, Characters3 {name='gummy', lifeValue=100}, Characters3 {name='baby', lifeValue=10000}, 123, Characters3 {name='gummy', lifeValue=100}]

        System.out.println(s.contains(new Characters("gummy", 100)));//true

        s.remove(new Characters("gummy",100));
        System.out.println(s);

        System.out.println(s.contains(new Characters("gummy", 100)));//false
    }
}
