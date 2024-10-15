package stream.test_data;

import java.util.ArrayList;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/7/3 下午 12:58
 * @Version 1.0
 */
public class TestData {
    public static ArrayList<Employee> getEmployees(){
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1,"Brian",24,3000));
        employees.add(new Employee(2,"Jason",70,7000));
        employees.add(new Employee(3,"Baby",15,5000));
        employees.add(new Employee(4,"Gummy",50,9000));
        employees.add(new Employee(5,"Ray",18,12000));

        return employees;
    }
}
