package com.array;

/**
 * ClassName: ArrayExer4
 * Description:
 *
 * @Author Rin
 * @Create 2024/2/27 下午 02:57
 * @Version 1.0
 */
public class ArrayExer4 {
    public static void main(String[] args){
        //[][0] = "10"代表普通職員，"11"代表程序員，"12"代表設計師
        String[][] employees = new String[][]{
                {"10","1","段譽"},
                {"11","2","令狐沖"},
                {"12","3","蕭峰"},
        };
        System.out.println("員工類型\t\t編號\t\t姓名");
        System.out.println("--------if-else ver--------");
        for (int i = 0; i <employees.length; i++) {
            if(employees[i][0].equals("10")) {
                System.out.print("普通職員\t\t");

            }else if(employees[i][0].equals("11")) {
                System.out.print("程序員\t\t");

            }else if(employees[i][0].equals("12")) {
                System.out.print("設計師\t\t");

            }
            for (int j = 1; j < employees[i].length; j++) {
                System.out.print(employees[i][j]+"\t\t\t");
            }
            System.out.println();
        }

        System.out.println("--------switch ver--------");
        for (int i = 0; i <employees.length; i++) {
            switch (employees[i][0]) {
                case "10":
                    System.out.print("普通職員\t\t");
                    break;
                case "11":
                    System.out.print("程序員\t\t");
                    break;
                case "12":
                    System.out.print("設計師\t\t");
                    break;
            }
            for (int j = 1; j < employees[i].length; j++) {
                System.out.print(employees[i][j]+"\t\t\t");
            }
            System.out.println();
        }
    }
}
