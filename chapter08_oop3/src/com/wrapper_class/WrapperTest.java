package com.wrapper_class;

import org.junit.Test;

/**
 * ClassName:
 * Description:
 *                包裝類 <-> 基本數據類型，底層執行解析。
 *                jdk5.0後，基本數據類型 <---> 包裝類 : 自動封箱、自動拆箱。
 *                         基本數據類型、包裝類 ---> String : String的 valueOf(xxx)
 *                         String ---> 基本數據類型、包裝類 : 包裝類的 parseXxx(String str)
 *
 * @Author Rin
 * @Create 2024/4/7 下午 06:34
 * @Version 1.0
 */
public class WrapperTest {


    @Test
    public void test0(){
        int i1 = 10;
        Integer integer1 = i1;
        System.out.println(i1 == integer1); // true，integer1自動拆箱
        System.out.println(integer1.equals(i1)); // true，i1自動封箱

        boolean bo1 = true;
        Boolean boolean1 = bo1;
        System.out.println(bo1 == boolean1); // true，boolean1自動拆箱
        System.out.println(boolean1.equals(bo1)); // true，bo1自動封箱

    }
    @Test
    public void test1(){
        int i1 = 10;
        Integer integer1 = new Integer(i1); //deprecated，還能用旦盡量避免。
        System.out.println(integer1);

        Integer integer2 = Integer.valueOf(i1);
        System.out.println(integer2);

        System.out.println(integer1 == integer2); // false，不同物件
        System.out.println(integer1.equals(integer2)); // true，值相同
    }

    @Test
    public void test2(){
        boolean bo1 = true;
        Boolean boolean1 = new Boolean(bo1);
        Boolean boolean2 = Boolean.valueOf(bo1);
        System.out.println(boolean1 == boolean2); //不同物件，==比的是地址值
        System.out.println(boolean1.equals(boolean2));

        Boolean boolean3 = Boolean.valueOf("truue");// is not true, so is false.
        System.out.println(boolean3); //false

        Boolean boolean4 = Boolean.valueOf("1321456");// is not true, so is false.
        System.out.println(boolean4); //false

        Boolean boolean5 = Boolean.valueOf("tRuE"); // ignoreCase true is true.
        System.out.println(boolean5); //true
    }

    /**
     * Integer -> int (包裝類 -> 基本數據類型 )
     * 使用 intValue()
     */
    @Test
    public void test3(){
        Integer integer1 = Integer.valueOf(10);
        int i1 = integer1.intValue(); // Integer -> int (包裝類 -> 基本數據類型 )
        System.out.println(i1);

        while (integer1 == 10){ //true，代表再條件判斷與語句時，會自動調integer1.intvalue();
            System.out.println("這是Interger包裝類的10");
            break;
        }
    }

    /**
     * Boolean -> boolean (包裝類 -> 基本數據類型 )
     * 使用 booleanValue()
     */
    @Test
    public void test4(){
        Boolean boolean1 = Boolean.valueOf("true"); //true
        boolean bo1 = boolean1.booleanValue(); // Boolean -> boolean (包裝類 -> 基本數據類型 )
        System.out.println(bo1);

        while (bo1){
            System.out.println("這是基本數據類型的true");
            break;
        }

        while (boolean1){ //true，代表再條件判斷與語句時，會自動調boolean1.booleanvalue();
            System.out.println("這是包裝類Boolean的true");
            break;
        }
    }
}
