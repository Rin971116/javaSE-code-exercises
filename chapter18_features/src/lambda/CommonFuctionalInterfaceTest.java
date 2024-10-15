package lambda;

import org.junit.Test;
import reflectapply.Person;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * ClassName:
 * Description:
 *              java.util.function包下定義了許多函數式接口
 *
 *                  四大基本的 函數式接口:
 *                                          接口            聲明的抽象方法
 *                           消費型接口: Consumer <T>      void accept(T t)
 *                           供給型接口: Supplier <T>      T get()
 *                           函數型接口: Function <T,R>    R apply(T t)
 *                           判斷型接口: Predicate<T>      boolean test(T t)
 *
 *                  方法引用: 使用條件為 1.抽象方法 其方法體中只有一行語句、並且該一行語句是使用 其他方法
 *                                    2.抽象方法 與 方法體中使用的該方法，有相同的 返回值類型、所需型參類表
 *                                    滿足上述條件 其實就可以看成只是方法名換了包另一個方法，故稱為方法引用
 *
 *                                    Comparator<Integer> comp2 = Integer :: compare;
 *                                    型參、返回值類型都不用寫，因為在寫抽象方法的時候 早都寫好 是要哪些類型了!!
 *                                    故滿足上述條件下，可以看成重寫的抽象方法其實就是 調用Integer類的compare()。
 *
 * @Author Rin
 * @Create 2024/7/1 下午 10:35
 * @Version 1.0
 */
public class CommonFuctionalInterfaceTest {
    /**
     *  Comparator 測試
     */
    @Test
    public void test1(){

        //普通方式:
        Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        System.out.println(comp.compare(11, 16)); //-1

        //Lambda表達式: 簡單來說就是 把以往的 new Comparator{...@Override...} 簡化成 只描述重寫的方法，
        // 格式為 (所需的型參) -> 方法體(也就是要拿這些型參做的操作)
        Comparator<Integer> comp1 = (o1,o2) -> Integer.compare(o1,o2);
        System.out.println(comp1.compare(11, 16)); //-1

        //方法引用: 使用條件為 1.抽象方法 其方法體中只有一行語句、並且該一行語句是使用 其他方法
        //                   2.抽象方法 與 方法體中使用的該方法，有相同的 返回值類型、所需型參類表
        //                   滿足上述條件 其實就可以看成只是方法名換了包另一個方法，故稱為方法引用
        Comparator<Integer> comp2 = Integer :: compare; //型參、返回值類型都不用寫，因為在寫抽象方法的時候 早都寫好 是要哪些類型了!!
        //故滿足上述條件下，可以看成重寫的抽象方法其實就是 調用Integer類的compare()。
        System.out.println(comp2.compare(11, 16)); //-1
    }

    /**
     * 消費型接口: Consumer <T>      void accept(T t)
     * 使用場景: 只需要參數，不需要返回值時
     */
    @Test
    public void test2(){
        //普通方式:
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("test123");

        //Lambda表達式:
        Consumer<String> con1 = s -> System.out.println(s);
        con1.accept("test456");

        //方法引用:
        Consumer<String> con2 = System.out :: println;
        con2.accept("test789");
    }

    /**
     * 供給型接口: Supplier <T>      T get()
     * 使用場景: 不需要參數，只需要返回值時
     */
    @Test
    public void test3(){
        //普通方式:
        Supplier<Person> sup = new Supplier<Person>() {
            @Override
            public Person get() {
                return new Person();
            }
        };
        System.out.println(sup.get());

        //Lambda表達式:
        Supplier<Person> sup1 = () -> new Person();
        System.out.println(sup1.get());

        //方法引用:
        Supplier<Person> sup2 = Person :: new;
        System.out.println(sup2.get());
    }

    /**
     * 函數型接口: Function <T,R>    R apply(T t)
     * 使用場景: 需要參數、返回值時
     */
    @Test
    public void test4(){
        //普通方式:
        Function<Integer,Person[]> func = new Function<Integer, Person[]>() {
            @Override
            public Person[] apply(Integer len) {
                return new Person[len];
            }
        };
        System.out.println(func.apply(5).length);

        //Lambda表達式:
        Function<Integer,Person[]> func1 = (len) -> new Person[len];
        System.out.println(func1.apply(6).length);

        //方法引用:
        Function<Integer,Person[]> func2 = Person[] :: new; //這邊可以將 new Person[len] 解讀成用 Person 調 構造器方法 len則為其參數
        System.out.println(func2.apply(7).length);
    }

    /**
     * 判斷型接口: Predicate<T>      boolean test(T t)
     * 使用場景: 需要參數，需要 boolean返回值，需要判斷時
     */
    @Test
    public void test5(){
        //普通方式:
        Predicate<Integer> pred = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 0;
            }
        };
        System.out.println(pred.test(5)); //true

        //Lambda表達式:
        Predicate<Integer> pred1 = integer -> integer > 0;
        System.out.println(pred1.test(-3)); //false

        //方法引用: 此舉例 方法體非 一行、同型參、同返回值的方法 ，無法使用方法引用
//        Predicate<Integer> pred2 =
    }
}
