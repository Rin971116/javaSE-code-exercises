package com.throwTest;

import org.junit.Test;

/**
 * ClassName:
 * Description:
 *                  在方法內部手動拋出異常(throw)，開發時用在 自定義需要拋出異常 的場景下，代表編譯是沒問題的，但當用戶做出不符合
 *                  你預設的選項時，可以選擇手動拋出異常，停止後續的程序繼續執行。
 *
 *                  手動拋出(throw)異常對象後，該異常對象還在方法內，此時可以選擇 2種處理異常的方式:
 *                  1.在方法內部使用 try{...} catch{...} finally{...}去直接解決。
 *                  2.正常方法，在方法型參後方，使用 throws 把異常拋給調用此方法者去解決。
 * @Author Rin
 * @Create 2024/4/12 下午 03:31
 * @Version 1.0
 */
public class ThrowTest {

    @Test
    public void test1() { //方式1.
        Student s = new Student();
//        s.regist(123);
        s.regist(-111);

    }
    @Test
    public void test2() { //方式2.
        Student s = new Student();
        try {
            s.regist2(-111);
        }catch(SelfDefineException e){
            e.printStackTrace();
        }
    }
}


class Student {
    private int id;

    /**
     * 1.在方法內部使用 try{...} catch{...} finally{...}去直接解決。
     * @param id
     */
    public void regist(int id) {
        try {
            if (id >= 0) {
                this.id = id;
            } else {
                throw new Exception("輸入非法id"); //自定義規則下，手動拋出異常。
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println(toString());
        }
    }

    /**
     * 2.正常方法，在方法型參後方，使用 throws 把異常拋給調用此方法者去解決。
     * @param id
     * @throws SelfDefineException
     */
    public void regist2(int id) throws SelfDefineException{

        if (id >= 0) {
            this.id = id;
        } else {
            throw new SelfDefineException("輸入非法id"); //自定義規則下，手動拋出異常。
        }

    }

    @Override
    public String toString() {
        return "Student{id:" + this.id + "}";
    }
}
