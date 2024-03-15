package EmployeeAccountingSystem.EmployeeEdit;

import constants.ConstOther;
import generalMenu.EmployeeMenu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EmployeeDelete {
    public static void dismissalOfEmployees() throws FileNotFoundException {
        System.out.println("\n\t-[ Введите ID работника, которого хотите уволить ]-\n");
        Scanner scanner = new Scanner(System.in);
        deleteEmployee(scanner.nextLong());
        EmployeeMenu.menu();
    }
    public static void deleteEmployee(Long id){
        File folder = new File(ConstOther.FILE_PATH_EMPLOYEES + id + ".txt");
        folder.delete();
    }
}
