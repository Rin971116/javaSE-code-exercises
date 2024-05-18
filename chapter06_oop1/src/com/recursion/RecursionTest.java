package com.recursion;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/9 上午 12:59
 * @Version 1.0
 */
public class RecursionTest {
    public static void main(String[] args) {
        RecursionTest rt = new RecursionTest();
        System.out.println(rt.getSum(100));
        System.out.println(rt.getSum1(100));
        System.out.println(rt.getMul(10));

    }

    /**
     * 舉例1；計算1-100內自然數的總和
     */
    public int getSum(int num) {
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum += i;
        }
        return sum;
    }

    public int getSum1(int num) {
        if (num > 0) {
            return (getSum(num - 1) + num);
        } else return num;
    }

    /**
     * 舉例2: 計算 n!
     */
    public int getMul(int num) {
        if (num == 1) {
            return 1;
        } else return (num * getMul(num - 1));
    }
}

    /**
     * 舉例3: quickSort
     * 舉例4: fibonacci
     * 舉例5: han-no Tower game
     */

    /**
     * 如下遞歸方法的調用，會導致StackOverflowError
     */

