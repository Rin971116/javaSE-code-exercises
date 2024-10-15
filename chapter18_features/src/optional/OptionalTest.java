package optional;

import org.junit.Test;

import java.util.Optional;

/**
 * ClassName:
 * Description:
 *                  Optional類，簡單來說就是 類的 包裝類，為了防止空指針異常的 保險作法
 *                              透過一個 Optional<T>類的實例對象 內部有一屬性 T value 存放我們的目標物件
 *                              在存取 我們目標物件 之前，先透過 Optional物件調用 orElse(T other)，並傳入一個備案物件，
 *                              此方法會判斷當前 Optional物件中的 value == null，如果不是返回 value，是則返回剛剛傳入的備案物件
 *
 *                              步驟 1: 實例化方式: Optional類的靜態方法  ofNullable(T value): 參數傳入目標物件
 *                              步驟 2: orElse(T other)，並傳入一個備案物件，獲取返回值(目標 or備案)
 *
 *                              常用方法 get()，可以取出內部 value的值，前提是 value != null，是 null的話 則報異常
 *
 *
 * @Author Rin
 * @Create 2024/7/12 上午 03:28
 * @Version 1.0
 */
public class OptionalTest {
    @Test
    public void test1(){
        String str = "gummy";
        str = null;
        Optional<String> o = Optional.ofNullable(str);
        String finalStr = o.orElse(new String("brian")); //if value != null , return value , if value == null , return other
        System.out.println(finalStr);
    }
}
