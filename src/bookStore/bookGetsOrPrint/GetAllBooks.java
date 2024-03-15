package bookStore.bookGetsOrPrint;

import EmployeeAccountingSystem.EmployeeEntities.Department;
import EmployeeAccountingSystem.EmployeeEntities.Employee;
import EmployeeAccountingSystem.EmployeeEntities.Gender;
import EmployeeAccountingSystem.EmployeeEntities.Job;
import bookStore.bookEntities.Book;
import constants.ConstOther;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GetAllBooks {
    private static ArrayList<String> tempFile;
    public static List<Book> getBooks() throws FileNotFoundException {
        try {
            File folder = new File(ConstOther.FILE_PATH_BOOKS);
            File[] files = folder.listFiles();
            List<Book> books = new ArrayList<>();
            for (int i = 0; i < files.length; i++) {
                tempFile = new ArrayList<>();
                File file = files[i];
                FileReader fr = new FileReader(file);
                BufferedReader reader = new BufferedReader(fr);
                String line = reader.readLine();
                while (line != null) {
                    tempFile.add(line);
                    line = reader.readLine();
                }
                Book book = new Book();
                book.setTitle(tempFile.get(0));
                book.setAuthor(tempFile.get(1));
                book.setPublishingHouse(tempFile.get(2));
                book.setNumberOfPages(Integer.parseInt(tempFile.get(3)));
                book.setGenre(tempFile.get(4));
                book.setDate(LocalDate.parse(tempFile.get(5)));
                book.setPrice(Integer.parseInt(tempFile.get(6)));
                books.add(book);
            }
            return books;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
