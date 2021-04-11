package CaseStudy.Manager;

import CaseStudy.Commons.FileUtils;
import CaseStudy.Models.Employee;

import java.util.*;

public class EmployeeManager {
    public static void searchEmployee(){
        List<Employee> employeeList = FileUtils.readFileEmployee();
        Stack<Employee> employeeStack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        for (Employee employee: employeeList){
            employeeStack.push(employee);
        }

        System.out.println("Nhập tên cần tìm: ");
        String empSearch = sc.nextLine();
        for (Employee employee: employeeStack){
            if (employee.getNameEmp().contains(empSearch)){
                System.out.println("Nhân viên ở vị trí: " + employeeStack.search(employee));
                System.out.println(employee);
            }
        }
    }
    public static void showEmployee(){
        List<Employee> employeeList = FileUtils.readFileEmployee();
        Map<Integer, Employee> map = new HashMap<>();
        for (int i = 0; i < employeeList.size(); i++){
            map.put((i+1), employeeList.get(i));
        }
        for (Map.Entry<Integer, Employee> entry : map.entrySet()){
            System.out.println(entry.getKey() + ".\t" + entry.getValue());
        }
    }
}
