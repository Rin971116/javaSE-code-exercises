package com.exer2;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/4/15 下午 06:40
 * @Version 1.0
 */
public class DivisionDemo {

    //以下throws的異常除了BelowZeroException 以外，都是運行時異常(RuntimeException)，其實都不需要處理or往外拋出，下面為了演示才加的。
    public static int divide(int dividend, int divisor) throws BelowZeroException, NumberFormatException, ArrayIndexOutOfBoundsException,
            ArithmeticException{
        if (dividend < 0 || divisor < 0){
            throw new BelowZeroException("數字小於0");
        }else {
            return dividend / divisor;
        }
    }
}
