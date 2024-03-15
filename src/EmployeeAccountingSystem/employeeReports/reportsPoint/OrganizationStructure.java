package EmployeeAccountingSystem.employeeReports.reportsPoint;

import EmployeeAccountingSystem.employeeReports.ReportsMenu;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class OrganizationStructure {
    public static void structure() throws FileNotFoundException {
        System.out.println("\n\t-[ Отчет ]-");
        System.out.println("\n\t-[ Система учета сотрудников ]-");
        System.out.println("\n\t-[ Должности ]-");
        System.out.println("\t[1] Директор\n" +
                        "\t[2] Заместитель директора\n" +
                        "\t[3] Бухгалтер\n" +
                        "\t[4] Диспетчер\n" +
                        "\t[5] Менеджер\n" +
                        "\t[6] Инженер\n" +
                        "\t[7] Сварщик\n");
        System.out.println("\n\t-[ Названия отделов ]-");
        System.out.println("\t[1] Ремонтный отдел\n" +
                "\t[2] Научный отдел\n" +
                "\t[3] Технический отдел\n" +
                "\t[4] Отдел рекламы");
        System.out.println("\n\t-[ У каждого сотрудника есть свой начальник, начальник это человек с должностью <Директо> ]-");
        System.out.println("\n\t-[ Зарплата распределяется в зависимости от должности ]-");
        System.out.println("\n\t-[ В профиле у каждого сотрудника есть его контактный телефон для связи ]-");

        System.out.println("\n\t-[ Чтобы вернуться в меню, введите любой символ]-");
        String commandNumber = new Scanner(System.in).nextLine();
        ReportsMenu.menuStart();
    }
}
