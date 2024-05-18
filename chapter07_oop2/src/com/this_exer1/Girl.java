package com.this_exer1;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/12 下午 05:06
 * @Version 1.0
 */
public class Girl {
    private String name;
    private int age;

    public Girl(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void marry(Boy boy){
        System.out.println("我想嫁給"+boy.getName());
        boy.marry(this); //這邊型參輸入this表示當前物件
    }

    /**
     * 比較兩個物件的大小
     * @param girl
     * @return 正數:當前物件大; 負數:當前物件小; 0:相等
     */
    public int compare(Girl girl){
        if(this.age > girl.age){
            return 1;
        } else if (this.age < girl.age){
            return -1;
        } else{
            return 0;
        }
    }
}
