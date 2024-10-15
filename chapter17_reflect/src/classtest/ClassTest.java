package classtest;

import org.junit.Test;

/**
 * ClassName:
 * Description:
 *                  步驟 1.  透過 Class對象實例 調用 getDeclaredField(String fieldName) : return Field物件
 *
 *                          透過 Class對象實例 調用 getDeclaredMethod(String methodName, Class ... args) : return Method物件
 *                                  第二參數開始是可變型參，若有重載的方法可以放入指定型參 的 Class對象，比如 String.class , int.class
 *
 *                          透過 Class對象實例 調用 getDeclaredConstructor(Class ... args) : return Constructor物件
 *                                  獲取指定參數類型的構造器
 *
 *                  步驟 2. setAccessible(true): 設定 此屬性、方法、構造器 是可訪問的
 *
 *                  步驟 3.  通過 Field實例調用 get(Object obj), set(Object obj, Object value)
 *                          通過 Method實例調用 invoke(Object obj, Object ... objs),即為調用 該Method物件 所指向的方法，
 *                          特別的是返回值類型會跟 指向的方法返回值一樣，若是void 則返回 null。
 *                          通過Contructor實例調用 newInstance(Object obj),返回一個運行時類的實例
 * @Author Rin
 * @Create 2024/6/21 下午 06:33
 * @Version 1.0
 */
public class ClassTest {
    @Test
    public void test1(){

    }
}
