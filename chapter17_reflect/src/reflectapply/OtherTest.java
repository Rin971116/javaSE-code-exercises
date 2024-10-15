package reflectapply;

import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * ClassName:
 * Description:
 *                  獲取運行時類的內部結構 2: 父類、接口們、包、帶泛型的父類、父類的泛型等
 *                  以下範例 因沒有提供 目標類的 src下的 全路徑類名 比如("com.classloader.person")，所以用 ""示意而已
 * @Author Rin
 * @Create 2024/6/18 下午 07:37
 * @Version 1.0
 */
public class OtherTest {
    /**
     * 1. 獲取運行時類的父類，打印結果不會包含父類的泛型
     */
    @Test
    public void test1() throws ClassNotFoundException {
        Class aClass = Class.forName("");
        Class superclass = aClass.getSuperclass();
        System.out.println(superclass);
    }

    /**
     * 2. 獲取運行時類 實現的接口
     */
    @Test
    public void test2() throws ClassNotFoundException {
        Class aClass = Class.forName("");
        Class[] interfaces = aClass.getInterfaces();
        for (Class c : interfaces){
            System.out.println(c);
        }
    }

    /**
     * 3. 獲取運行時類所在的包 (package)
     */
    @Test
    public void test3() throws ClassNotFoundException {
        Class aClass = Class.forName("");
        Package aPackage = aClass.getPackage();
        System.out.println(aPackage);
    }

    /**
     * 4. 獲取運行時類的父類，打印結果 包含父類的泛型
     * @throws ClassNotFoundException
     */
    @Test
    public void test4() throws ClassNotFoundException {
        Class aClass = Class.forName("");
        Type genericSuperclass = aClass.getGenericSuperclass(); //返回帶泛型的父類
        System.out.println(genericSuperclass);
    }

    /**
     * 5. 獲取運行時類的父類的泛型(難，之後複製來用就行)
     * @throws ClassNotFoundException
     */
    @Test
    public void test5() throws ClassNotFoundException {

        //參數放入目標類的 src下的 全路徑類名 比如("com.classloader.person")
        Class aClass = Class.forName("");

        //獲取帶泛型的父類，Type 是 Class 實現的一個接口
        Type genericSuperclass = aClass.getGenericSuperclass();

        //如果父類是帶泛型的，可以強轉成ParameterizedType
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;

        //透過調用 getActualTypeArguments() 獲取泛型的參數，返回一個數組，因為可能有多個泛型參數
        Type[] arguments = parameterizedType.getActualTypeArguments();

        for (Type t : arguments){
            //Type 是 Class 實現的一個接口
            System.out.println(((Class) t).getName());
        }
    }

}
