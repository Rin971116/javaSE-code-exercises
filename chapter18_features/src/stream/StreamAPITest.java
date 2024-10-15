package stream;

import org.junit.Test;
import stream.test_data.Employee;
import stream.test_data.TestData;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ClassName:
 * Description:
 *                  stream本身的概念就很像 遍歷 數組or集合，至於輪流拿到每個元素後要做什麼操作，則看你中間操作、終止操作怎麼使用 的感覺
 *                  特色: 使用stream做任何 篩選、過濾、增刪改查 的操作，都不會影響到實際的 數組or集合，也就是說不會影響 元數據
 *
 *                      Stream API的規則:
 *                                          步驟 1: 透過數組或集合 的對象調用 stream()，獲取欲操作的 數組或集合 的 Stream對象
 *                                          步驟 2: 欲執行的一系列 中間操作，比如 filter(),limit()等
 *                                          步驟 3: 一定要的執行 終止操作 比如 foreach()，倘若沒寫終止操作，則所有 中間操作都不會被執行
 * @Author Rin
 * @Create 2024/7/3 下午 12:51
 * @Version 1.0
 */
public class StreamAPITest {
    /**
     *  透過 stream 調用 filter(Predicate p): 接收 Lambda，透過 流 對數組or集合進行過濾篩選，
     *  比較 普通方式、Lambda、方法引用 三種方式之間的差異
     */
    @Test
    public void test1(){
        ArrayList<Employee> list = TestData.getEmployees();
        Stream<Employee> stream = list.stream();

        //方式1: 不使用stream 的基礎方法
//        ArrayList<Employee> list1 = new ArrayList<>();
//        for (Employee e : list){
//            if (e.getSalary() > 7000){
//                list1.add(e);
//            }
//        }
//        for (Employee e : list1){
//            System.out.println(e);
//        }

        //方式2: 使用stream.filter()
        stream.filter(new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getSalary() > 7000;
            }
        }).forEach(new Consumer<Employee>() {
            @Override
            public void accept(Employee employee) {
                System.out.println(employee);
            }
        });

        //方式3: 使用stream.filter()，並且簡化成Lambda、方法引用
        //看到函數式接口就要知道一定可以使用Lambda，但能不能使用 方法引用 就看你的方法體具體情況
        list.stream().filter((employee) -> {return employee.getSalary() > 7000;}).forEach((employee)->{
            System.out.println(employee);
        });

        //方式4: 進一步將forEach()所需的Consumer實例改成 方法引用
        list.stream().filter(employee -> employee.getSalary() > 7000).forEach(System.out :: println);

    }

    /**
     * 常用(中間操作)的方法:
     *              filter(): 篩選，篩選規則透過參數 Predicate實例 實現的抽象方法 作條件判斷
     *              limit(): 從 index 0開始取 n 個元素
     *              skip(): 從 index 0開始跳過 n 個元素
     *              distinct(): 移除相同的物件
     *              sorted(): 排序，當然說到排序，欲排序的元素就要能夠 比較 才行，也就是說要實現Comparable接口，或是sorted()要傳入 Comparator實例
     *              map(): 映射，比如說將 一個stream中的所有物件 映射成 其中每個物件的某成員屬性 傳回新的 stream
     */
    @Test
    public void test2(){
        ArrayList<Employee> list = TestData.getEmployees();
        System.out.println("1--------------");
        list.stream().filter((employee) -> employee.getSalary() > 3000).forEach(System.out::println);

        System.out.println("2--------------");
        list.stream().filter((employee) -> employee.getSalary() > 3000).limit(3).forEach(System.out::println);

        System.out.println("3--------------");
        list.stream().filter((employee) -> employee.getSalary() > 3000).limit(3).skip(2).forEach(System.out::println);

        System.out.println("4--------------");
        list.add(new Employee(6,"Kevin",50,6000));
        list.add(new Employee(6,"Kevin",50,6000));
        list.add(new Employee(6,"Kevin",50,6000));
        list.stream().distinct().forEach(System.out::println);

        System.out.println("5--------------");
//        list.stream().sorted().forEach(System.out::println); 欲使用無參的sorted()，那Employee本身要實現Comparable接口
        list.stream().sorted((emp1,emp2) -> Integer.compare(emp1.getSalary(),emp2.getSalary())).forEach(System.out::println);

        System.out.println("6--------------");
        list.stream().map((employee) -> employee.getName()).sorted((str1,str2) -> str1.compareTo(str2)).forEach(System.out::println);
    }
    /**
     * 常見(終止操作)的方法:
     *              1. allMatch(): 返回 boolean值，是否全部符合
     *              2. anyMatch(): 返回 boolean值，是否有 任何一個符合
     *              3. findFirst(): 返回 stream中當前的第一個元素
     *              4. count(): 返回 stream中當前的 元素個數
     *              5. max(): 返回當前 stream中 最大的元素，至於何為最大?則看你參數的 Comparator怎麼寫
     *              6. min(): 返回當前 stream中 最小的元素，至於何為最小?則看你參數的 Comparator怎麼寫
     *              7. forEach(): 遍歷操作，具體拿到每個元素要做什麼，則看參數的抽象方法怎麼寫
     *              8. reduce(): 可以將 stream中的元素 加總起來 返回一個值
     *              9. collect(Collector c): 把 stream一頓操作下來 當前的元素 存成一個新的 數組or集合 返回，
     *                                    至於型參的 Collector的實例 對象 可以直接使用 Collectors的靜態方法 toList()、toXxx()獲取
     *             10. toList(): 跟 collect()一樣
     */
    @Test
    public void test3(){
        ArrayList<Employee> list = TestData.getEmployees();

        System.out.println("1--------------");
        System.out.println(list.stream().allMatch((employee) -> employee.getSalary() > 7000)); //false

        System.out.println("2--------------");
        System.out.println(list.stream().anyMatch((employee) -> employee.getSalary() > 10000)); //true

        System.out.println("3--------------");
        Optional<Employee> first = list.stream().filter((employee) -> employee.getSalary() > 10000).findFirst(); //返回一個Optional對象
        System.out.println(first); //若只想Optional對象中的employee對象的話，調用get()
        Employee emp = first.get();
        System.out.println(emp);

        System.out.println("4--------------");
        System.out.println(list.stream().filter((employee) -> employee.getSalary() > 7000).count());
        List<Employee> list1 = list.stream().filter((employee) -> employee.getSalary() > 7000).toList();
        list1.forEach(System.out::println);
        System.out.println(list1 == list); //false

        System.out.println("5--------------");
        System.out.println(list.stream().max((emp1, emp2) -> Integer.compare(emp1.getSalary(), emp2.getSalary())));
        System.out.println(list.stream().min((emp1, emp2) -> Integer.compare(emp1.getSalary(), emp2.getSalary())));

        System.out.println("6--------------");
        System.out.println(list.stream().map((employee) -> employee.getSalary()).reduce(0, (i1, i2) -> i1 + i2));// identity代表起始值

        System.out.println("7--------------");
        List<Employee> list2 = list.stream().filter((employee) -> employee.getSalary() > 7000).collect(Collectors.toList());
        list2.forEach(System.out::println);
        System.out.println(list2 == list); //false
    }

    /**
     * 按照員工的年齡進行排列，返回到一個新的 List中
     */
    @Test
    public void exer(){
        ArrayList<Employee> list = TestData.getEmployees();
        List<Employee> sortList = list.stream().sorted((emp1, emp2) -> Integer.compare(emp1.getAge(), emp2.getAge())).toList();
        sortList.forEach(System.out::println);
    }
}
