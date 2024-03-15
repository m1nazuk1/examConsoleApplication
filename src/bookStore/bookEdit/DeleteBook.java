package bookStore.bookEdit;

import bookStore.WorkWithFilesBooks;
import bookStore.bookEntities.Book;
import bookStore.bookGetsOrPrint.GetAllBooks;
import generalMenu.BookStoreMenu;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DeleteBook {
    public static void deletes(){
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

        System.out.println("\n\t-[ Введите номер книги, которую хотите удалить ]-\n");

        int id = new Scanner(System.in).nextInt();

        WorkWithFilesBooks.deleteBooks(map.get(id));

        BookStoreMenu.menu();
    }
}
