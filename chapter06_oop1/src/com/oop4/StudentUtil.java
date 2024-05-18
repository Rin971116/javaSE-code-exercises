package com.oop4;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/3/6 下午 09:44
 * @Version 1.0
 */
public class StudentUtil {
    /**
     * 打印指定年級的學生信息
     * @param state 傳入的指定年級
     */
    public static void printSpecifyState(Student[] students, int state) {
        System.out.println("---------state "+state+" member---------");
        for (int i = 0; i < students.length; i++) {
            if (students[i].getState() == 3) {
                students[i].showInfo();
            }
        }
    }

    /**
     * 遍歷student[]中的所有學生，並showInfo
     * @param students 傳入的目標array
     */
    public static void printAllStudents(Student[] students){
        System.out.println("--------- all students ---------");
        for (int i = 0; i < students.length; i++) {
            students[i].showInfo();
        }
    }

    /**
     * 依照傳入的Student[]中的每個student物件的成績進行由小到大的排序
     * @param students 傳入的目標array
     */
    public static void bubbleSort(Student[] students){
        Student temp;
        for (int i = 0; i < students.length-1; i++) {
            for (int j = 0; j < students.length-1-i; j++) {
                if (students[j].score > students[j + 1].score) {
                    temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }
}
