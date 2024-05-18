package com.wrapper_class;

import org.junit.Test;

/**
 * ClassName:
 * Description:
 *              String轉基本數據類型，使用 各自包裝類下的方法； parseInt(String xxx), pareBoolean(String str), ...
 *
 *              背後運行為； String --------------------> 包裝類 ----------------> 基本數據類型
 *                                  (使用 parseXxx())             (自動拆箱)
 *
 * @Author Rin
 * @Create 2024/4/8 下午 02:47
 * @Version 1.0
 */
public class WrapperTest2 {
    @Test
    public void test1(){
        String str1 = "true";
        String str2 = "123";

        boolean bo1 = Boolean.parseBoolean(str1); //true
        boolean bo2 = Boolean.parseBoolean(str2); //只要輸入的值非true，就是false
        int i1 = Integer.parseInt(str2); // 123

        System.out.println(i1 + 10); //133
        System.out.println(bo2);


    }

    @Test
    public void test2(){
        int i1 = 10;
        boolean bo1 = true;

        String str1 = String.valueOf(i1);
        System.out.println(str1); // "10"

        String str2 = String.valueOf(bo1);
        System.out.println(str2); // "true"

    }


}
