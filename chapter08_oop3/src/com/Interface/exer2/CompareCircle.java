package com.Interface.exer2;

/**
 * ClassName:
 * Description:
 *              假設情境為 Circle類是別人提供的，我們想比較其物件，但又不能直接更改 Circle類的情況下，
 *              就可以創立 Circle的子類，然後在新的子類下去同時實現 CompareObject接口
 *              之後建立對象就可以建立我們自定義的子類，一來它有 Circle的全部元素，二來它實現了 CompareObject接口，可以進行比較，
 *              至此擴展成功
 * @Author Rin
 * @Create 2024/4/1 下午 03:52
 * @Version 1.0
 */
public class CompareCircle extends Circle implements CompareObject{ //解讀成CompareCircle這個類可以比較大小，因為他實現了CompareObject
    public CompareCircle() {
    }

    public CompareCircle(double radius) {
        super(radius);
    }

    /**
     * 根據對象的半徑大小，比較兩對象的大小
     * @param o
     * @return 若返回值為0，代表相等，正數代表當前對象大，負數代表當前對象小
     */
    @Override
    public int compareTo(Object o){
        if (o instanceof CompareCircle) {
            CompareCircle c = (CompareCircle) o;
            //方法1.
//            if (this.getRadius() > c.getRadius()) {
//                return 1;
//            } else if (this.getRadius() == c.getRadius()) {
//                return 0;
//            } else if (this.getRadius() < c.getRadius()) {
//                return -1;
//            }

            //方法2.
            return Double.compare(this.getRadius(),c.getRadius());
        }else {
            return 2; //暫且無解
//            throw new RuntimeException("輸入類型錯誤",new Throwable("輸入錯誤"));
        }
    }

}
