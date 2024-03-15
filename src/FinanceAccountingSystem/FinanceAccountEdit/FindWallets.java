package FinanceAccountingSystem.FinanceAccountEdit;

import EmployeeAccountingSystem.EmployeeEntities.Department;
import EmployeeAccountingSystem.EmployeeEntities.Employee;
import EmployeeAccountingSystem.EmployeeGetsOrPrint.GetAllEmployee;
import FinanceAccountingSystem.FinanceAccountGetsOrPrint.GetsAllWallets;
import FinanceAccountingSystem.financeEntities.FinanceAccount;
import generalMenu.FinanceAccountingSystemMenu;

import java.util.List;
import java.util.Scanner;

public class FindWallets {
    public static void find(){
        System.out.println("\n\t-[ выберите параметр, по которому хотите найти кошелек ]-\n");
        System.out.println("\n\t[1] название карты" +
                "\n\t[2] номер карты" +
                "\n\t[3] id карты" +
                "\n\t[0] выход\n");
        int commandNumber = new Scanner(System.in).nextInt();

        switch (commandNumber){
            case 1 -> findWithCardName();
            case 2 -> findWithCardNumber();
            case 3 -> findWithId();
            case 0 -> FinanceAccountingSystemMenu.menu();
        }
    }

    private static void findWithId(){
        System.out.println("\n\t-[ введите id карты ]-\n");
        long id = new Scanner(System.in).nextLong();
        List<FinanceAccount> financeAccountList = GetsAllWallets.getAllWallet();
        for (FinanceAccount a : financeAccountList) {
            if (a.getId().equals(id)) {
                System.out.println(a.toString());
            }
        }
        find();
    }

    private static void findWithCardName(){
        System.out.println("\n\t-[ введите название карты ]-\n");
        String name = new Scanner(System.in).nextLine();
        List<FinanceAccount> financeAccountList = GetsAllWallets.getAllWallet();
        for (FinanceAccount a : financeAccountList) {
            if (a.getNameOfCard().equals(name)) {
                System.out.println(a.toString());
            }
        }
        find();
    }

    private static void findWithCardNumber(){
        System.out.println("\n\t-[ введите номер карты ]-\n");
        int number = new Scanner(System.in).nextInt();
        List<FinanceAccount> financeAccountList = GetsAllWallets.getAllWallet();
        for (FinanceAccount a : financeAccountList) {
            if (a.getNumberOfCard() == number) {
                System.out.println(a.toString());
            }
        }
        find();
    }
}
