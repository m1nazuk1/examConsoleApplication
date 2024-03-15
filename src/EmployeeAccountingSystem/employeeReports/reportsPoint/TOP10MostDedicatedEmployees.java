package EmployeeAccountingSystem.employeeReports.reportsPoint;

import EmployeeAccountingSystem.EmployeeEntities.Employee;
import EmployeeAccountingSystem.EmployeeGetsOrPrint.GetAllEmployee;
import EmployeeAccountingSystem.employeeReports.ReportsMenu;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TOP10MostDedicatedEmployees {
    public static void sorted() throws FileNotFoundException {
        List<Employee> employeeList = GetAllEmployee.getEmployees();

        List<Employee> sorted = new ArrayList<>();
        sorted = employeeList.stream().sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList());
        int count = sorted.size();
        String[] build = new String[10];
        for (Employee employee : sorted){
            if (count <= 10) build[count-1] = "" + "\t[" + count + "] " + employee.getName() + " | " + employee.getSalary() + "";
            count--;
            if (count == 0) break;
        }

        for (int i = 0; i < build.length; i++){
            if (build[i] != null) System.out.println(build[i] + "\n");
        }

        ReportsMenu.menuStart();
    }
}
