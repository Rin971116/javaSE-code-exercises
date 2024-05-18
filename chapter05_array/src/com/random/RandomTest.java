package com.random;

/**
 * ClassName: RandomTest
 * Description:
 *
 * @Author Rin
 * @Create 2024/2/27 下午 09:30
 * @Version 1.0
 */
/*如何獲取隨機數?
1.可以使用java提供的api:Math類的random()
2.radom()調用以後，會返回一個[0.0-1.0)範圍的double型的隨機數，也就是大於等於0.0，小於1.0。
3.需求1: 獲取一個[0,100]範圍的隨機整數
  需求2: 獲取一個[1,100]範圍的隨機整數
  需求3: 獲取一個[a,b]範圍的隨機整數?
  ->(int)(Math.random() * (b+1-a)) + a
*/
public class RandomTest {
    public static void main(String[] args) {
        double d1 = Math.random();
        System.out.println("d1:"+d1);
       //1.double強轉成int時，擷取到整數後，就無法繼續存取，造成類似無條件捨去的效果，若剛好為整數也會-1。[0-100]
        int num1 = (int) (Math.random()*101);
        System.out.println("num1:"+num1);
        //2.[0-99] -----整體+1----> [1-100]
        int num2 = (int) (Math.random()*100)+1;
        System.out.println("num2:"+num2);
    }
}
