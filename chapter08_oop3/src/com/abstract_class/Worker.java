package com.abstract_class;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/28 上午 01:06
 * @Version 1.0
 */
public abstract class Worker extends Person{
    @Override
    public void sleep() {
        System.out.println("工人起的早，午休也睡覺");
    }

}
