package com.throwTest;

/**
 * ClassName:
 * Description:
 *              如何聲明自定義異常類:
 *              1.繼承於 Exception / RuntimeException
 *              2.通常提供幾個重載的構造器
 *              3.提供一個全局常量，聲明為: static final long serialVersionUID;
 *
 *              為什麼要使用自定義異常類: 見名知意
 *
 * @Author Rin
 * @Create 2024/4/15 下午 01:50
 * @Version 1.0
 */
public class SelfDefineException extends Exception{

    static final long serialVersionUID = -1237516993124229948L;//識別號，改一下別跟別人一樣
    public SelfDefineException() {
    }

    public SelfDefineException(String message) {
        super(message);
    }

    public SelfDefineException(String message, Throwable cause) {
        super(message, cause);
    }

    public SelfDefineException(Throwable cause) {
        super(cause);
    }

    public SelfDefineException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
