package bookStore.bookEdit;

import EmployeeAccountingSystem.EmployeeEntities.Employee;
import EmployeeAccountingSystem.EmployeeGetsOrPrint.GetAllEmployee;
import EmployeeAccountingSystem.EmployeeGetsOrPrint.PrintAllEmployee;
import FinanceAccountingSystem.FinanceAccountGetsOrPrint.GetsAllWallets;
import FinanceAccountingSystem.FinanceAcountingEditWithExcel.AddCardInExcel;
import FinanceAccountingSystem.financeEntities.FinanceAccount;
import bookStore.bookEntities.Book;
import bookStore.bookGetsOrPrint.GetAllBooks;
import bookStore.bookGetsOrPrint.PrintAllBooks;
import bookStore.excelWork.AddAll;
import constants.ConstOther;
import generalMenu.BookStoreMenu;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class ChoiceOfFavoriteBook {
    public static void choice(){
        System.out.println("\n\t-[ введите номер сотрудника, кому будете выбирать любимую книгу ]-\n");

        List<Employee> employeeList = null;
        try {
            employeeList = GetAllEmployee.getEmployees();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < employeeList.size(); i++) {
            System.out.println("[" + (i+1) + "] " + employeeList.get(i).getName() + " " + employeeList.get(i).getSurname() + "\n");
        }

        long id = new Scanner(System.in).nextLong();

        System.out.println("\n\t-[ выберите книгу ]-\n");
        try {
            PrintAllBooks.printAll();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        int number = new Scanner(System.in).nextInt();

        createFavoriteBook(number-1, id);
        BookStoreMenu.menu();

    }

    public static void createFavoriteBook(int numberBook, long numberEmployee){
        List<FinanceAccount> financeAccounts = GetsAllWallets.getAllWallet();
        List<Employee> employees;
        List<Book> books;
        try {
            books = GetAllBooks.getBooks();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            employees = GetAllEmployee.getEmployees();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        AddAll.add(ConstOther.FILE_PATH_END, financeAccounts, employees, books,numberBook, numberEmployee);

    }
}
