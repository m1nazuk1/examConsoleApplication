package generalMenu;

import EmployeeAccountingSystem.EmployeeEdit.EmployeeAdd;
import EmployeeAccountingSystem.EmployeeEdit.EmployeeChange;
import EmployeeAccountingSystem.EmployeeEdit.EmployeeDelete;
import EmployeeAccountingSystem.EmployeeEdit.EmployeeFind;
import EmployeeAccountingSystem.EmployeeEntities.Employee;
import EmployeeAccountingSystem.EmployeeGetsOrPrint.GetAllEmployee;
import EmployeeAccountingSystem.EmployeeGetsOrPrint.PrintAllEmployee;
import EmployeeAccountingSystem.employeeReports.ReportsMenu;
import EmployeeAccountingSystem.excelWorkEmployee.ReadExcel;
import EmployeeAccountingSystem.excelWorkEmployee.WriteInExcel;
import constants.ConstOther;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class EmployeeMenu {
    public static void menu() throws FileNotFoundException {
        System.out.println("\n\t[1] Принятие на работу новых сотрудников\n" +
                "\t[2] Увольнение сотрудников\n" +
                "\t[3] Изменение информации о сотрудниках\n" +
                "\t[4] Поиск сотрудников\n" +
                "\t[5] Создание отчетов\n" +
                "\t[6] Вывод всех сотрудников\n" +
                "\t[7] Ввод всех сотрудников в Excel\n" +
                "\t[8] Вывод всех сотрудников из Excel\n" +
                "\t[0] Выход\n");
        int commandNumber = new Scanner(System.in).nextInt();
        switch (commandNumber){
            case 1 -> {
                EmployeeAdd.addingAnEmployee();
                menu();
            }
            case 2 -> {
                EmployeeDelete.dismissalOfEmployees();
                menu();
            }
            case 3 -> {
                EmployeeChange.changeStart();
                menu();
            }
            case 4 -> {
                EmployeeFind.findMenu();
                menu();
            }
            case 5 -> {
                ReportsMenu.menuStart();
                menu();
            }
            case 6 -> {
                PrintAllEmployee.printAll();
                menu();
            }
            case 7 -> {
                List<Employee> list = GetAllEmployee.getEmployees();
                WriteInExcel.write(ConstOther.FILE_PATH_EXCEL, list);
                menu();
            }
            case 8 -> {
                try {
                    System.out.println(ReadExcel.readJExcel(ConstOther.FILE_PATH_FIND));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                menu();
            }
            case 0 -> MyMenu.menu();
            default -> menu();
        }
    }
}
