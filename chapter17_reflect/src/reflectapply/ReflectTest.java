package reflectapply;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * ClassName:
 * Description:
 *                  一次編譯，只會加載一次類，該類就會放在 方法區
 * @Author Rin
 * @Create 2024/6/19 下午 02:02
 * @Version 1.0
 */
public class ReflectTest {
    @Test
    public void test1() throws Exception {
        //加載類 的方式1.
        //Class<Person> clazz1 = Person.class;

        //加載類 的方式2.(常用):
        //Class.forName(String className) 會加載類，並生成一個對應的Clazz對象，但其概念不是一般的構造器造對象，是執行 "類構造器" <clinit>()加載類
        Class clazz = Class.forName("reflectapply.Person");

        Person person = (Person) clazz.newInstance();

        //getField()只能獲取public的屬性
//        Field nameField = clazz.getField("name");

        //getDeclaredField() 可以獲取 任何類中聲明的屬性
        Field nameField = clazz.getDeclaredField("name");

        //將nameField的訪問權限 設定成true，因為Person中的name屬性 是聲明成private的
        nameField.setAccessible(true);

        nameField.set(person,"Tom");
        System.out.println(nameField.get(person));
    }
}
