package com.use;

import org.junit.Test;

import java.util.*;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/5/17 下午 07:50
 * @Version 1.0
 */
public class CollectionMapTest {
    @Test
    public void test1(){
//        Scanner<Integer> sc = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList(); // 表示該ArrayList中只能存放Integer物件

        HashMap<String, Integer> map = new HashMap<>(); //key只能存放String，value只能存放Integer
        HashMap<String, Object> map1 = new HashMap<>();



        Comparator<Employee> comparator = new Comparator<>() {
            //訂製排序
            @Override
            public int compare(Employee o1, Employee o2) {
                //1. 比年紀
                int ageDiff = o1.getAge() - o2.getAge();
                if (ageDiff != 0){
                    return ageDiff;
                }

                //2. 比id
                int idDiff = o1.getId().compareTo(o2.getId());
                if (idDiff != 0){
                    return idDiff;
                }

                //3. 比name
                return o1.getName().compareTo(o2.getName());
            }
        };


        System.out.println("以下為訂製排序");

        Set<Employee> treeSet = new TreeSet<>(comparator);
//        treeSet.add(123); 不是Employee物件 就無法傳入，這就是使用泛型的好處
        treeSet.add(new Employee("brian",21,"b123123123"));
        treeSet.add(new Employee("gummy",23,"a123123123"));

        Iterator<Employee> iterator = treeSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


        System.out.println("以下為自然排序");

        Set<Employee> treeSet2 = new TreeSet<>();
        treeSet2.add(new Employee("brian",21,"b123123123"));
        treeSet2.add(new Employee("gummy",23,"a123123123"));

        Iterator<Employee> iterator2 = treeSet2.iterator();
        while (iterator2.hasNext()){
            System.out.println(iterator2.next());
        }

    }
}
