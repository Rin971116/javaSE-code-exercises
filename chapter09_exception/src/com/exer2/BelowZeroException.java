package com.exer2;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/4/15 下午 06:43
 * @Version 1.0
 */
public class BelowZeroException extends RuntimeException{
    static final long serialVersionUID= -1245516993124229948L;

    public BelowZeroException() {
    }

    public BelowZeroException(String message) {
        super(message);
    }

    public BelowZeroException(String message, Throwable cause) {
        super(message, cause);
    }

    public BelowZeroException(Throwable cause) {
        super(cause);
    }

    public BelowZeroException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
