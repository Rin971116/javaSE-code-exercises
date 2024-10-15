package exer;

import reflectapply.Person;

import java.lang.reflect.Constructor;

/**
 * ClassName:
 * Description:
 *                      反射: 動態性的體現
 * @Author Rin
 * @Create 2024/6/26 下午 02:58
 * @Version 1.0
 */
public class ReflectTest {
    /**
     * 靜態方式造對象 :
     *      缺點 : 靈活性低、擴展性低，老方法只能在編寫代碼時就寫死 要造甚麼類的對象
     *      優點 : 效率高、可讀性高，沒特殊需求還是使用這種方式
     * @return
     */
    public Person getInstance(){
        return new Person();
    }

    /**
     * 動態方式獲取指定類 建立對象，通常搭配泛型使用
     *      優點 : 靈活性高、擴展性高，可以依靠傳入的參數(通常為 String的 類的全域名、方法名、屬性名...)，來決定要獲某類的對象，或某類的某方法、某屬性
     *      缺點 : 效率低、可讀性低
     * @param className
     * @return
     * @param <T>
     * @throws Exception
     */
    public <T> T getInstance(String className) throws Exception {
        Class clazz = Class.forName(className);
        Constructor cons = clazz.getDeclaredConstructor();
        cons.setAccessible(true);
        return (T) cons.newInstance();
    }
}
