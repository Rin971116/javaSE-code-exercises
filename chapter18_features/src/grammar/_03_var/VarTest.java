package grammar._03_var;

import org.junit.Test;

import java.util.ArrayList;

/**
 * ClassName:
 * Description:
 *                  使用 var 作為 變量的型別，必須是 可以自動推斷 的場景下層能夠使用
 *
 * @Author Rin
 * @Create 2024/7/9 下午 07:10
 * @Version 1.0
 */
public class VarTest {
    @Test
    public void test1(){
        //正確使用:
        var number = 123;
        var nums = new int[]{11,22,67}; //用後面的 推斷 前面的
        int[] nums1 = {11,22,34}; //這也是自動類型推斷的一種，用前面的 推斷 後面的
        var list = new ArrayList<String>();

        //錯誤使用:
//        var number1;
//        var nums2 = {11,22,33}; 無法推斷的場景，前面、後面都沒有，當然無法推斷
    }
}
