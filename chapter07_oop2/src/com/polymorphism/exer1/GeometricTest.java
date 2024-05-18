package com.polymorphism.exer1;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/21 上午 12:29
 * @Version 1.0
 */
public class GeometricTest {

    public static void main(String[] args) {
        GeometricTest test = new GeometricTest();

        Circle c1 = new Circle("white",1.0,2.3);
        Circle c2 = new Circle("black",1.0,6.6);

        test.displayGeometricObject(c1); //GeometricObject g1 = c1;
        test.displayGeometricObject(c2);

        boolean isEqual = test.equalsArea(c1,c2);
        System.out.println(isEqual?"same":"diffrent");

        //使用匿名物件
        test.displayGeometricObject(new MyRectangle("white",1.0,11.0,16.0));

    }
    /**
     * 比較兩個幾何圖形的面積是否相等
     * @param g1 幾何圖形1
     * @param g2 幾何圖形2
     * @return true:相等 ; false:不相等
     */
    public boolean equalsArea(GeometricObject g1, GeometricObject g2){
        return (g1.findArea() == g2.findArea());
    }

    /**
     * 顯示幾何圖形的面積
     * @param g1
     */
    public void displayGeometricObject(GeometricObject g1){
        System.out.println(g1.findArea());
    }
}
