package com.selfdefine;

import java.util.ArrayList;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/5/24 上午 01:16
 * @Version 1.0
 */
public class Order <T>{

    /**
     * 聲明泛型方法 格式:
     *                      權限修飾符 <泛型> 泛型 方法名(泛型 參數名){};
     *                      上面 <泛型> 的意義是為了告知編譯器該方法是泛型方法，不然編譯器會將 E 認為是一個 類(class)
     *                      並且泛型方法能夠聲明為static，原理只要想有沒有 指定泛型類型的時機就行
     *
     */
    public <E> ArrayList<E> getArraylist(E[] arr){
        ArrayList<E> eList = new ArrayList<>();
        for (E e : arr){
            eList.add(e);
        }
        return eList;
    }
    public <E> ArrayList<E> getArraylist2(E[] arr){
        ArrayList<E> eList = new ArrayList<>();
        for (E e : arr){
            eList.add(e);
        }
        return eList;
    }
    private T field ; // 型別:T ; 變數名:field
    private String name;

    public Order(T field, String name) {
        this.field = field;
        this.name = name;
    }

    public Order() {

    }

    public void show(T field){
        System.out.println(field);
    }
}
