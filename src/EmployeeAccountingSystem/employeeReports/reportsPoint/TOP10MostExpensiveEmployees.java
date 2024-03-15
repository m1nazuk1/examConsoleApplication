package EmployeeAccountingSystem.employeeReports.reportsPoint;

import EmployeeAccountingSystem.EmployeeEntities.Employee;
import EmployeeAccountingSystem.EmployeeGetsOrPrint.GetAllEmployee;
import EmployeeAccountingSystem.employeeReports.ReportsMenu;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TOP10MostExpensiveEmployees {
    public static void sorted() throws FileNotFoundException {
        List<Employee> employeeList = GetAllEmployee.getEmployees();

        List<Employee> sorted = new ArrayList<>();
        sorted = employeeList.stream().sorted(Comparator.comparing(Employee::getEmploymentDate)).collect(Collectors.toList());
        int count = 1;
        for (Employee employee : sorted){
            if (count <= 10) System.out.println("\t[" + count + "] " + employee.getName() + " | " + employee.getEmploymentDate() + "\n");
            count++;
        }

        ReportsMenu.menuStart();
    }
}
