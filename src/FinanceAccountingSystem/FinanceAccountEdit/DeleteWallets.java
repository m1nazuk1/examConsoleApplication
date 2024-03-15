package FinanceAccountingSystem.FinanceAccountEdit;

import constants.ConstOther;
import generalMenu.FinanceAccountingSystemMenu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DeleteWallets {
    public static void dismissalOfEmployees() throws FileNotFoundException {
        System.out.println("\n\t-[ Введите ID кошелька, который хотите удалить ]-\n");
        Scanner scanner = new Scanner(System.in);
        deleteWallet(scanner.nextLong());
        FinanceAccountingSystemMenu.menu();
    }
    public static void deleteWallet(Long id){
        File folder = new File(ConstOther.FILE_PATH_CARDS + id + ".txt");
        folder.delete();
    }
}
