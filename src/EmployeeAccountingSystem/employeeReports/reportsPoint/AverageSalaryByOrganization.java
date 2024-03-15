package EmployeeAccountingSystem.employeeReports.reportsPoint;

import EmployeeAccountingSystem.EmployeeEntities.Employee;
import EmployeeAccountingSystem.EmployeeGetsOrPrint.GetAllEmployee;
import EmployeeAccountingSystem.employeeReports.ReportsMenu;

import java.io.FileNotFoundException;
import java.util.List;

public class AverageSalaryByOrganization {
    public static void averageSalaryByOrg() throws FileNotFoundException {
        List<Employee> employeeList = GetAllEmployee.getEmployees();
        int sum = 0;
        int answer = 0;

        for (Employee employee : employeeList){
            sum += employee.getSalary();
        }

        answer = sum/employeeList.size();

        System.out.println("\n\t-[ Отчет ]-");
        System.out.println("\n\t-[ Средняя зарплата по организации составляет - " + answer + " ]-");

        ReportsMenu.menuStart();
    }

}
