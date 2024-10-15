package com.collections_tool_class;

import java.util.*;

/**
 * ClassName:
 * Description:
 *                  Collections 為 Collection類的工具類
 * @Author Rin
 * @Create 2024/5/17 下午 05:45
 * @Version 1.0
 */
public class CollectionsTest {

    /**
     * Collections的常用方法
     */

    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList(Arrays.asList(3, 6, 1, 2, 9, 7, 8, 5, 4)); //Arrays.asList()返回的是一個不可改變大小的數組
        //錯誤的方法
//        ArrayList list2 = new ArrayList();
//        Collections.copy(list2,list1); //Source does not fit in dest，底層原理要求list2.size()要 >= list1.size()

        //copy()
        List list2 = Arrays.asList(new Object[list1.size()]); //小技巧，建立一個欲需複製list 一樣多元素的newlist
        Collections.copy(list2,list1);
        System.out.println(list2);

        //sort(): //默認自然排序 從小到大
        //sort(Collection coll, Comparator c): 傳入Comparator類物件，以訂製排序
        Collections.sort(list1);
        System.out.println("list1 自然排序過後:" + list1);

        Collections.sort(list1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -(o1 - o2); //反過來排 由大到小
            }
        });
        System.out.println("list1 訂製排序過後:" + list1);


        List list3 = new ArrayList();
        //synchronizedXxx()
        List threadSafeList = Collections.synchronizedList(list3); //返回一個線程安全的list物件
        Map threadSafeMap = Collections.synchronizedMap(new HashMap<String,Integer>()); //返回一個線程安全的map物件

        //inner class
        class Task implements Runnable{
            private List threadSafeList;

            public Task(List threadSafeList) {
                this.threadSafeList = threadSafeList;
            }

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    threadSafeList.add(i);
                    System.out.println(Thread.currentThread().getName() + " 执行第 " + (i+1) + " 次");
                }
            }
        }

        Runnable task = new Task(threadSafeList);

        Thread thread1 = new Thread(task, "线程1");
        Thread thread2 = new Thread(task, "线程2");

        thread1.start();
        thread2.start();

        // 等待两个线程完成
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 打印list3的内容
        System.out.println(list3); //若不等待，則main thread 走到這時，thread1、thread2都還沒執行完run()，自然print出來就會不完整
        System.out.println("threadSafeList 共有" + threadSafeList.size() + "個元素");
    }


}
