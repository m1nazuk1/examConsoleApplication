package EmployeeAccountingSystem.EmployeeGetsOrPrint;

import EmployeeAccountingSystem.EmployeeEntities.Employee;
import generalMenu.EmployeeMenu;

import java.io.FileNotFoundException;
import java.util.List;

public class PrintAllEmployee {
    public static void printAll() throws FileNotFoundException {
        List<Employee> employeeList = GetAllEmployee.getEmployees();
        for (int i = 0; i < employeeList.size(); i++) {
            System.out.println(employeeList.get(i) + "\n");
        }
        EmployeeMenu.menu();
    }
}
