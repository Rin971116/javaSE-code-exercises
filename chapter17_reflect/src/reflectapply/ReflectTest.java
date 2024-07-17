package reflectapply.apply2;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/6/19 下午 02:02
 * @Version 1.0
 */
public class ReflectTest {
    @Test
    public void test1() throws Exception {
        Class<Person> clazz = Person.class;

        Person person = clazz.newInstance();

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
