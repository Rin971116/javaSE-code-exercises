package com.oop4;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/6 下午 06:46
 * @Version 1.0
 */
public class StudentTest {
    public static void main(String[] args) {
        Student[] students = new Student[20];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student(i+1);
        }

        StudentUtil.printAllStudents(students);

        StudentUtil.bubbleSort(students);
        System.out.println("---------is sort---------");
        StudentUtil.printAllStudents(students);
        System.out.println(students[0]); //地址值
    }
}
