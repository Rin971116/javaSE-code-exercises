package com.selfdefine.apply;

import java.util.List;

/**
 * ClassName:
 * Description:
 *              DAO: data(base) access object. 內部封裝了操作數據庫相關表的曾刪改查。(CRUD)
 *
 * @Author Rin
 * @Create 2024/5/26 上午 04:07
 * @Version 1.0
 */
public class DAO<T> {
    //增
    public void add(T target){

    }

    //刪
    public T remove(int id){
        return null;
    }

    //改
    public void replace(int id, T newTarget){}

    //查
    public T reserch(int id){
        return null;
    }

    //查群體
    public List<T> reserchAll(int id){
        return null;
    }

    //定義泛型方法: 跟泛型類完全可以分開
    //比如: 查詢表中的總資料數。(此時 E 可以指名為 Long類型)
    //比如: 查詢表中最大生日。(此時 E 可以指名為 Date類型)
    public <E> E getValue(String sql){
        return null;
    }
}
