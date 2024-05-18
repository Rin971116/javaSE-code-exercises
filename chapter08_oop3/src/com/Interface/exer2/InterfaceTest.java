package com.Interface.exer2;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/4/1 下午 04:31
 * @Version 1.0
 */
public class InterfaceTest {

    public static void main(String[] args) {
        CompareCircle c1 = new CompareCircle(2.1);
        CompareCircle c2 = new CompareCircle(1.6);

        Circle c3 = new Circle(2.1);
        Circle c4 = new Circle(1.6);
        int compareResult = c1.compareTo(c2);
        int compareResult2 = c3.compareTo(c4);

        if (compareResult > 0) {
            System.out.println("c1大");
        } else if (compareResult < 0) {
            System.out.println("c2大");
        } else if (compareResult == 0) {
            System.out.println("一樣大");
        }

        if (compareResult2 > 0) {
            System.out.println("c3大");
        } else if (compareResult < 0) {
            System.out.println("c4大");
        } else if (compareResult == 0) {
            System.out.println("一樣大");
        }
    }
}
