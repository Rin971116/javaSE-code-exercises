package com.Interface.exer2;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/4/1 下午 03:45
 * @Version 1.0
 */
public interface CompareObject {
    //若返回值為0，代表相等，正數代表當前對象大，負數代表當前對象小
    public abstract int compareTo(Object o); //體現規範用途。抽象方法可先寫死需要的 返回值、型參列表，只要沒有方法體就可以
}
