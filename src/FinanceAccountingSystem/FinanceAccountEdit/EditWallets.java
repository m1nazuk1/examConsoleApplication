package FinanceAccountingSystem.FinanceAccountEdit;

import EmployeeAccountingSystem.EmployeeGetsOrPrint.GetAllEmployee;
import FinanceAccountingSystem.FinanceAccountGetsOrPrint.GetsAllWallets;
import FinanceAccountingSystem.WorkWithFilesFinanceAccount;
import FinanceAccountingSystem.financeEntities.FinanceAccount;
import generalMenu.FinanceAccountingSystemMenu;
import generalMenu.MyMenu;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class EditWallets {
    private static long id = 0;
    public static void edit(){
        System.out.println("\n\t-[ для начала выберите id кошелька, параметры карт которого вы будете изменять ]-\n");

        List<FinanceAccount> financeAccounts = GetsAllWallets.getAllWallet();
        for (int i = 0; i < financeAccounts.size(); i++) {
            System.out.println(financeAccounts.get(i) + "\n");
        }

        id = new Scanner(System.in).nextLong();

        System.out.println("\n\t-[ выберите параметр для изменения ]-\n");
        System.out.println("\t[1] название карты" +
                "\n\t[2] название потенциальных затрат" +
                "\n\t[3] название текущих затрат" +
                "\n\t[4] название потенциального дохода" +
                "\n\t[0] выход");

        int commandNumber = new Scanner(System.in).nextInt();
        switch (commandNumber){
            case 1 -> editWithNameOfCard();
            case 2 -> editWithNameOfThePotentialCost();
            case 3 -> editCurrentCostName();
            case 4 -> editNamePotentialIncome();
            case 0 -> FinanceAccountingSystemMenu.menu();
        }
    }

    private static void editWithNameOfCard(){
        List<FinanceAccount> financeAccountList = GetsAllWallets.getAllWallet();
        for (FinanceAccount a : financeAccountList) {
            if (a.getId().equals(id)) {
                System.out.println("\n\t-[ введите новое название карты ]-\n");
                String name = new Scanner(System.in).nextLine();
                a.setNameOfCard(name);
                WorkWithFilesFinanceAccount.write(a.toString(), id);
            }
        }
    }

    private static void editWithNameOfThePotentialCost(){
        List<FinanceAccount> financeAccountList = GetsAllWallets.getAllWallet();
        for (FinanceAccount a : financeAccountList) {
            if (a.getId().equals(id)) {
                System.out.println("\n\t-[ введите новое название потенциальных затрат ]-\n");
                String name = new Scanner(System.in).nextLine();
                a.setNameOfThePotentialCost(name);
                WorkWithFilesFinanceAccount.write(a.toString(), id);
            }
        }
    }

    private static void editCurrentCostName(){
        List<FinanceAccount> financeAccountList = GetsAllWallets.getAllWallet();
        for (FinanceAccount a : financeAccountList) {
            if (a.getId().equals(id)) {
                System.out.println("\n\t-[ введите новое название текущих затрат ]-\n");
                String name = new Scanner(System.in).nextLine();
                a.setCurrentCostName(name);
                WorkWithFilesFinanceAccount.write(a.toString(), id);
            }
        }
    }

    private static void editNamePotentialIncome(){
        List<FinanceAccount> financeAccountList = GetsAllWallets.getAllWallet();
        for (FinanceAccount a : financeAccountList) {
            if (a.getId().equals(id)) {
                System.out.println("\n\t-[ введите новое название потенциального дохода ]-\n");
                String name = new Scanner(System.in).nextLine();
                a.setNamePotentialIncome(name);
                WorkWithFilesFinanceAccount.write(a.toString(), id);
            }
        }
    }
}
