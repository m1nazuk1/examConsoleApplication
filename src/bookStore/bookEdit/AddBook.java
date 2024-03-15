package bookStore.bookEdit;

import bookStore.WorkWithFilesBooks;
import bookStore.bookEntities.Book;
import constants.ConstSample;
import generalMenu.BookStoreMenu;

import java.time.LocalDate;
import java.util.Scanner;

public class AddBook {
    public static void add(){
        Book book = new Book();
        System.out.println("\n\t-[ введите название книги ]-");
        book.setTitle(new Scanner(System.in).nextLine());
        System.out.println("\n\t-[ введите автора книги ]-");
        book.setAuthor(new Scanner(System.in).nextLine());
        System.out.println("\n\t-[ введите издательство книги ]-");
        book.setPublishingHouse(new Scanner(System.in).nextLine());
        System.out.println("\n\t-[ введите количество страниц ]-");
        book.setNumberOfPages(new Scanner(System.in).nextInt());
        System.out.println("\n\t-[ введите жанр книги ]-");
        book.setGenre(new Scanner(System.in).nextLine());
        System.out.println("\n\t-[ введите год издания книги ]-");
        book.setDate(date());
        System.out.println("\n\t-[ введите цену книги ]-");
        book.setPrice(new Scanner(System.in).nextInt());

        WorkWithFilesBooks.write(book.toString(), book.getTitle());

        BookStoreMenu.menu();
    }

    public static LocalDate date(){
        LocalDate myDate = null;
        String data = new Scanner(System.in).nextLine();

        String[] components = data.split("\\s+");
        if (components.length != 3) {
            System.out.println("\n\t-[ Неверный формат ]-");
            date();
        }else {
            String day = components[ConstSample.INDEX_DAY];
            if (!day.matches(ConstSample.DAY_TEMPLATE) || (Integer.parseInt(day) > 31)) {
                System.out.println("\n\t-[ Неверный формат дня в строке " + day + " ]-\n");
                date();
            }else{
                String month = components[ConstSample.INDEX_MONTH];
                if ((!month.matches(ConstSample.MONTH_TEMPLATE)) || (Integer.parseInt(month) > 12)) {
                    System.out.println("\n\t-[ Неверный формат месяца в строке " + month + " ]-\n");
                    date();
                }else {
                    String year = components[ConstSample.INDEX_YEAR];
                    if (!year.matches(ConstSample.YEAR_TEMPLATE) || (Integer.parseInt(year) > 2023) || (Integer.parseInt(year) < 1900)){
                        System.out.println("\n\t-[ Неверный формат года в строке " + year + "]-\n");
                        date();
                    }else {
                        myDate = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
                    }
                }
            }
        }
        return myDate;
    }
}
