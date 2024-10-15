package grammar._04_instanceof;

import org.junit.Test;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/7/9 下午 07:01
 * @Version 1.0
 */
public class InstanceOfTest {
    /**
     * 舊方法: 使用 instanceof 後，強轉
     */
    @Test
    public void test1(){
        Object o = "test123";
        if(o instanceof String){
            String str = (String) o;
            System.out.println(str);
        }
    }
    /**
     * 新方法: 使用 instanceof 後，直接加 變量名，代表若是 ture則自動強轉
     */
    @Test
    public void test2(){
        Object o = "test123";
        if(o instanceof String str){
//            String str = (String) o; 自動強轉的話，就不需要這行了
            System.out.println(str);
        }
    }
}
