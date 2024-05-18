package com.varargs;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/7 上午 02:56
 * @Version 1.0
 */
public class VarargaTest2 {
    public static void main(String[] args) {
        System.out.println(VarargaTest2.apendString("*","我","愛","小杯比"));
        System.out.println(VarargaTest2.apendString("*","我"));
        System.out.println(VarargaTest2.apendString("*"));

    }

    public static String apendString(String str1, String... str2){
        String allString = "";
        for (int i = 0; i < str2.length; i++) {
            if (i == 0){
                allString += str2[i];
            }else {
                allString += (str1 + str2[i]);
            }
        }
        return allString;
    }
}
