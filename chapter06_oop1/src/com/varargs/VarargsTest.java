package com.varargs;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/7 上午 02:20
 * @Version 1.0
 */
public class VarargsTest {
    public static void main(String[] args) {
        VarargsTest vt1 = new VarargsTest();
        vt1.print(1,2,3,4,5); //會找到(int... nums)的方法
        int[] arr = new int[]{1,2,3,4,5,6,7};
        vt1.print(arr); //會找到(int... nums)的方法
        vt1.print(1); //優先尋找更符合的型參，若找不到才會找到 型參為(int... nums)的方法
        vt1.print(1,2); //優先尋找更符合的型參
    }

    /**
     * 傳遞不定量參數 的方式
     * 並且不定參數的(...)語法，只能用在方法的最後一個參數。且與(int[] nums)視為相同的型參，因此不能同時存在。
     * 相比(int[] nums)絕對優勢在於，不管你傳入的是 n個int的參數，還是int[]的參數，java都能視為符合該型參。
     * 如果你傳入的是 n個int的參數，java則會自動幫你建立匿名array在傳給方法的型參
     * @param nums
     */
    public void print(int... nums){
        System.out.println("1111");
    }
    public void print(int num1){
        System.out.println("2222");
    }
    public void print(int num1, int num2){
        System.out.println("3333");
    }
}
