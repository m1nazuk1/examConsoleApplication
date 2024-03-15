package generalMenu;

import authorization.RegistrationDemo;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyMenu {
    public static void menu() throws FileNotFoundException {


        System.out.println("\n\t-[ Выберите проект, в который хотите переместиться ]-\n" +
                "\t[1] Система учета сотрудников\n" +
                "\t[2] Магазин книг\n" +
                "\t[3] Коллекция текстовых документов\n" +
                "\t[4] Система учета финансов\n" +
                "\t[0] Выход из аккаунта\n");
        Scanner scanner = new Scanner(System.in);
        int commandNumber = scanner.nextInt();
        switch (commandNumber){
            case 1 -> EmployeeMenu.menu();
            case 2 -> BookStoreMenu.menu();
            case 3 -> CollectionOfTextDocumentsMenu.menu();
            case 4 -> FinanceAccountingSystemMenu.menu();
            case 0 -> RegistrationDemo.start();
            default -> menu();
        }
    }
}
