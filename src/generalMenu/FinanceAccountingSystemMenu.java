package generalMenu;

import EmployeeAccountingSystem.EmployeeEntities.Employee;
import EmployeeAccountingSystem.EmployeeGetsOrPrint.GetAllEmployee;
import FinanceAccountingSystem.FinanceAccountEdit.AddWallets;
import FinanceAccountingSystem.FinanceAccountEdit.DeleteWallets;
import FinanceAccountingSystem.FinanceAccountEdit.EditWallets;
import FinanceAccountingSystem.FinanceAccountEdit.FindWallets;
import FinanceAccountingSystem.FinanceAccountGetsOrPrint.GetsAllWallets;
import FinanceAccountingSystem.FinanceAccountGetsOrPrint.PrintAllCards;
import FinanceAccountingSystem.FinanceAcountingEditWithExcel.AddCardInExcel;
import FinanceAccountingSystem.FinanceAcountingEditWithExcel.ReadCardsFromExcel;
import FinanceAccountingSystem.financeEntities.FinanceAccount;
import constants.ConstOther;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class FinanceAccountingSystemMenu {
    public static void menu(){
        System.out.println("\n\t[1] ввод новой карты" +
                "\n\t[2] поиск карты" +
                "\n\t[3] редактирование карты" +
                "\n\t[4] вывод карт в Excel" +
                "\n\t[5] считывание карт из Excel" +
                "\n\t[6] вывод всех карт" +
                "\n\t[7] удалить карту" +
                "\n\t[0] выход\n");
        int commandNumber = new Scanner(System.in).nextInt();
        System.out.println("\n");
        switch (commandNumber){
            case 1 -> {
                AddWallets.add();
                menu();
            }
            case 2 -> {
                FindWallets.find();
                menu();
            }
            case 3 -> {
                EditWallets.edit();
                menu();
            }
            case 4 -> {
                List<FinanceAccount> financeAccounts = GetsAllWallets.getAllWallet();
                List<Employee> employees;
                try {
                    employees = GetAllEmployee.getEmployees();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                AddCardInExcel.add(ConstOther.FILE_PATH_EXCEL, financeAccounts, employees);
                menu();
            }
            case 5 -> {
                try {
                    PrintAllCards.printSecond(ReadCardsFromExcel.readExcel(ConstOther.FILE_PATH_FIND));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                menu();
            }
            case 6 -> {
                PrintAllCards.print();
                menu();
            }
            case 7 -> {
                try {
                    DeleteWallets.dismissalOfEmployees();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                menu();
            }
            case 0 -> {
                try {
                    MyMenu.menu();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            default -> menu();
        }
    }
}
