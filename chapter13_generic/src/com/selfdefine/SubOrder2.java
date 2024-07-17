package com.selfdefine;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/5/24 下午 05:05
 * @Version 1.0
 */
public class SubOrder2<T> extends Order<T>{ //沿用父類泛型，一切使用該泛型(T)的地方，都在建立SubOrder2物件時指定，若沒指定，則默認Object
    public void show2(T field2){
        System.out.println(field2);
    }
}
