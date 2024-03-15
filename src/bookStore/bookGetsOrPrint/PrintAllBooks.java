package bookStore.bookGetsOrPrint;

import EmployeeAccountingSystem.EmployeeEntities.Employee;
import EmployeeAccountingSystem.EmployeeGetsOrPrint.GetAllEmployee;
import bookStore.bookEntities.Book;
import generalMenu.BookStoreMenu;
import generalMenu.EmployeeMenu;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintAllBooks {
    public static void printAll() throws FileNotFoundException {
        List<Book> list;
        try {
            list = GetAllBooks.getBooks();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        int i = 1;
        Map<Integer, String > map = new HashMap<>();
        for (Book book : list){
            System.out.println("[" + i + "] " + book.toString() + "\n");
            map.put(i, book.getTitle());
            i++;
        }

    }
}
