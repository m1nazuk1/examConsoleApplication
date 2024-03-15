package adminPanel;

import EmployeeAccountingSystem.EmployeeGetsOrPrint.GetAllEmployee;
import adminPanel.getAndPrintAllUsers.GetAllUsers;
import authorization.Entities.User;
import authorization.RegistrationDemo;
import authorization.workWithExcel.AddInExcelUsers;
import constants.ConstOther;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class AdminMenu {
    public static void menu() throws FileNotFoundException {
        System.out.println("\n\t[1] Удалить пользователя" +
                "\n\t[2] Вывод всех пользователей в Excel" +
                "\n\t[0] Выход\n");
        int commandNumber = new Scanner(System.in).nextInt();
        switch (commandNumber){
            case 1 -> AdminDelete.deleteUser();
            case 2 ->{
                List<User> users = GetAllUsers.getUsers();
                AddInExcelUsers.add(ConstOther.FILE_PATH_EXCEL_USER, users);
            }
            case 0 -> RegistrationDemo.first();
        }

    }
}
