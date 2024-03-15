package generalMenu;

import CollectionOfTextDocuments.DocumentsEdit.AddNotes;
import bookStore.bookEdit.AddBook;
import bookStore.bookEdit.ChoiceOfFavoriteBook;
import bookStore.bookEdit.DeleteBook;
import bookStore.bookEdit.EditBook;
import bookStore.bookEntities.Book;
import bookStore.bookGetsOrPrint.GetAllBooks;
import bookStore.bookGetsOrPrint.PrintAllBooks;
import bookStore.excelWork.WriteBookInExcel;
import constants.ConstOther;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class BookStoreMenu {
    public static void menu(){
        System.out.println("\n\t[1] добавление книги" +
                "\n\t[2] удаление книги" +
                "\n\t[3] работа с книгами" +
                "\n\t[4] вывод всех книг" +
                "\n\t[5] выбор любимой книги сотрудника" +
                "\n\t[6] выгрузка в Excel" +
                "\n\t[0] выход");


        switch (new Scanner(System.in).nextInt()){
            case 1 -> {
                AddBook.add();
            }
            case 2 -> {
                DeleteBook.deletes();
            }
            case 3 -> {
                EditBook.edit();
            }
            case 4 -> {
                try {
                    PrintAllBooks.printAll();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                menu();
            }
            case 5 -> {
                ChoiceOfFavoriteBook.choice();
            }
            case 6 -> {
                List<Book> list;
                try {
                    list = GetAllBooks.getBooks();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                try {
                    WriteBookInExcel.write(ConstOther.FILE_PATH_BOOKS_EXCEL, list);
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
        }
    }
}
