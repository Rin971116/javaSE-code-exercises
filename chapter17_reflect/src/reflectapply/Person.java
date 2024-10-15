package reflectapply;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/6/19 下午 02:03
 * @Version 1.0
 */
public class Person extends Creature {
    private String name;
    private int age;
    private static String info;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "reflectapply.apply2.Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static String getInfo() {
        return info;
    }

    public static void setInfo(String info) {
        Person.info = info;
    }
}
