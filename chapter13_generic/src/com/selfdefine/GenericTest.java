package com.selfdefine;

import org.junit.Test;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/5/24 上午 01:15
 * @Version 1.0
 */
public class GenericTest {
    @Test
    public void test1(){
        Order<Object> order = new Order<>("AA", "gummy"); //若沒指定泛型，則默認為Object
        Order<Integer> order1 = new Order<>(123, "gummy"); //因為指定了泛型T -> Integer，所以123作為Integer物件傳入
        
        order.show("ABCD");
//        order1.show("ABCD"); 編譯不通過，只能傳入Integer的物件
        order1.show(123456);
    }
    
    @Test
    public void test2(){
        
    }
}
