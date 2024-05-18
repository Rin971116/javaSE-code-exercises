package com.oop4;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/6 下午 06:45
 * @Version 1.0
 */
public class Student {
    int number;
    int state;
    int score;
    public Student(int number){
        this.number = number;
        state = (int) (Math.random() * 6 + 1);
        score = (int) (Math.random() * 101);
    }

    public int getState() {
        return state;
    }

    public void showInfo(){
        System.out.println("State:"+state+"\t  "+"Number:"+number+"\t  "+"score:"+score);
    }
}
