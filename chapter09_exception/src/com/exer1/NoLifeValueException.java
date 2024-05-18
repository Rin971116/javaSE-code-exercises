package com.exer1;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/4/15 下午 02:33
 * @Version 1.0
 */
public class NoLifeValueException extends RuntimeException{
    static final long serialVersionUID= -1235516993124229948L;

    public NoLifeValueException() {
    }

    public NoLifeValueException(String message) {
        super(message);
    }

    public NoLifeValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoLifeValueException(Throwable cause) {
        super(cause);
    }

    public NoLifeValueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
