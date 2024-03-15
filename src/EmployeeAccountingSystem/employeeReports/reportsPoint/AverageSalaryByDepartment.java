package EmployeeAccountingSystem.employeeReports.reportsPoint;

import EmployeeAccountingSystem.EmployeeEntities.Department;
import EmployeeAccountingSystem.EmployeeEntities.Employee;
import EmployeeAccountingSystem.EmployeeGetsOrPrint.GetAllEmployee;
import EmployeeAccountingSystem.employeeReports.ReportsMenu;
import generalMenu.EmployeeMenu;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class AverageSalaryByDepartment {
    public static void averageSalaryByDep() throws FileNotFoundException {

        System.out.println("\n\t-[ выберите название отдела ]-\n");
        System.out.println("\n\t[1] Ремонтный отдел\n" +
                "\t[2] Научный отдел\n" +
                "\t[3] Технический отдел\n" +
                "\t[4] Отдел рекламы\n" +
                "\t[0] Выход");
        int commandNumber =  new Scanner(System.in).nextInt();

        System.out.println("\n\t-[ Отчет ]-");

        switch (commandNumber){
            case 1 -> sumAverage(Department.REPAIR);
            case 2 -> sumAverage(Department.SCIENTIFIC);
            case 3 -> sumAverage(Department.TECHNICAL);
            case 4 -> sumAverage(Department.ADVERTISING);
            case 0 -> EmployeeMenu.menu();
            default -> averageSalaryByDep();
        }
        averageSalaryByDep();
    }

    public static void sumAverage(Department department) throws FileNotFoundException {
        int answer = 0;
        List<Employee> employeeList = GetAllEmployee.getEmployees();
        int sum = 0;
        int count = 0;
        for (Employee employee : employeeList){
            if (employee.getDepartment().equals(department)) {
                sum += employee.getSalary();
                count++;
            }
        }

        answer = sum/count;

        System.out.println("\n\t-[ Средняя зарплата по отделу " + department + " составляет - " + answer + " ]-");
        ReportsMenu.menuStart();

    }
}
