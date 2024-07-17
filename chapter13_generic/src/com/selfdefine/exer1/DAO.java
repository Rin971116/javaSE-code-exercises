package com.selfdefine.exer1;

import java.util.*;

/**
 * ClassName:
 * Description:
 *                  定義一個泛型類 DAO<T>，在其中定義一個 Map類成員，map的 key為string類型，value為 T類型
 * @Author Rin
 * @Create 2024/5/26 上午 04:45
 * @Version 1.0
 */
public class DAO<T> {
    private Map<String,T> map = new HashMap<>();

    public void save(String id, T entity){ //保存T類型的對象到map當中
        map.put(id,entity);
    }
}
