package bookStore.bookEdit;

import bookStore.bookEntities.Book;
import bookStore.bookGetsOrPrint.GetAllBooks;
import bookStore.excelWork.WriteBookInExcel;
import constants.ConstOther;
import constants.ConstSample;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EditBook {
    public static void edit(){
        System.out.println("\n\t-[ выберите номер книги для изменения ]-\n");

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

        int number = new Scanner(System.in).nextInt();

        for (Book book : list){
            if (book.getTitle().equals(map.get(number))){
                list.set(number-1, editBook(book));
            }
        }
        try {
            WriteBookInExcel.write(ConstOther.FILE_PATH_BOOKS_EXCEL, list);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    public static Book editBook(Book book){
        System.out.println("\n\t-[ какой параметр хотите изменить? ]-\n");
        System.out.println("\n\t[1] название" +
                "\n\t[2] автор" +
                "\n\t[3] издательство" +
                "\n\t[4] количество страниц" +
                "\n\t[5] жанр" +
                "\n\t[6] год издания" +
                "\n\t[7] цену\n");

        int commandNumber = new Scanner(System.in).nextInt();
        System.out.println("\n\t-[ введите новое занчение ]-\n");

        switch (commandNumber){
            case 1 -> {
                book.setTitle(new Scanner(System.in).nextLine());
            }
            case 2 -> {
                book.setAuthor(new Scanner(System.in).nextLine());
            }
            case 3 -> {
                book.setPublishingHouse(new Scanner(System.in).nextLine());
            }
            case 4 -> {
                book.setNumberOfPages(new Scanner(System.in).nextInt());
            }
            case 5 -> {
                book.setGenre(new Scanner(System.in).nextLine());
            }
            case 6 -> {
                book.setDate(date());
            }
            case 7 -> {
                book.setPrice(new Scanner(System.in).nextInt());
            }
        }

        return book;
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
