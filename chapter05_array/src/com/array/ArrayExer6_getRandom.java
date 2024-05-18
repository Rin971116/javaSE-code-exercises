package com.array;

/**
 * ClassName: ArrayExer6_getRandom
 * Description:
 *
 * @Author Rin
 * @Create 2024/2/27 下午 06:47
 * @Version 1.0
 */
//創建一個長度為6的int[]，要求其中元素的值都介於1~30之間，且是隨機賦值。同時，要求元素的值各不相同
class Test{
    boolean checkIsSame(int[] ia1, int i){
        for (int j = i-1; j >= 0; j--) {
            if(ia1[i] == ia1[j]){
                return true;
            }
        }return false;
    }
}

public class ArrayExer6_getRandom {
    public static void main(String[] args) {
        Test t1 = new Test();
        boolean isSame;
        int[] ia1 = new int[6];
        for (int i = 0; i < ia1.length; i++) {
            isSame = true;
            if(i == 0) {
                ia1[i] = (int) (Math.random() * 30) + 1;
            }else {
                while (isSame){
                    ia1[i] = (int) (Math.random() * 30) + 1;
                    isSame = t1.checkIsSame(ia1,i);
                }
            }
        }
        for(int elements : ia1){
            System.out.print(elements+"\t");
        }
    }
}
