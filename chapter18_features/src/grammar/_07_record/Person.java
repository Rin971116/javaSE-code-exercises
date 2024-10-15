package grammar._07_record;

import java.util.Objects;

/**
 * ClassName:
 * Description:
 *              建立一個 record 就等於 建立這樣一個結構的 java bean，內部包含:
 *
 *                                           1 聲明為final的成員變量 (畢竟使用 record相當你啥都沒寫，java在後台自動建立，所以變量只能是final的)
 *                                           2.為所有屬性賦值的構造器 (不包含空參的構造器)
 *                                           3.equals()、hashcode()
 *                                           4.toString()
 *
 *
 * @Author Rin
 * @Create 2024/7/11 下午 03:21
 * @Version 1.0
 */
public class Person {
    final private String name;
    final private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    //getName()，換名而已
    public String name() {
        return name;
    }

    //getAge()，換名而已
    public int age() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
