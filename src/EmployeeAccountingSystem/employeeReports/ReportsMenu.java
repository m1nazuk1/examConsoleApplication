package EmployeeAccountingSystem.employeeReports;

import EmployeeAccountingSystem.employeeReports.reportsPoint.*;
import generalMenu.EmployeeMenu;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReportsMenu {
    public static void menuStart() throws FileNotFoundException {
        System.out.println("\n\t-[ Отчеты ]-" +
                "\n\t[1] Структура организации" +
                "\n\t[2] Средняя зарплата по организации" +
                "\n\t[3] Средняя зарплата по отделу" +
                "\n\t[4] ТОП-10 самых дорогих сотрудников по зарплате" +
                "\n\t[5] ТОП-10 самых преданных сотрудников по количеству лет работы в организации" +
                "\n\t[0] Выход\n");
        int commandNumber = new Scanner(System.in).nextInt();
        switch (commandNumber){
            case 1 -> OrganizationStructure.structure();
            case 2 -> AverageSalaryByOrganization.averageSalaryByOrg();
            case 3 -> AverageSalaryByDepartment.averageSalaryByDep();
            case 4 -> TOP10MostDedicatedEmployees.sorted();
            case 5 -> TOP10MostExpensiveEmployees.sorted();
            case 0 -> EmployeeMenu.menu();
            default -> menuStart();
        }
    }
}
