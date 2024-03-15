package adminPanel;

import constants.ConstOther;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AdminDelete {
    public static void deleteUser() throws FileNotFoundException {
        System.out.println("\n\t-[ Введите ID пользователя, которого хотите удалить ]-\n");
        Scanner scanner = new Scanner(System.in);
        delete(scanner.nextLong());
        AdminMenu.menu();
    }

    public static void delete(Long id){
        File folder = new File(ConstOther.FILE_PATH + id + ".txt");
        folder.delete();
    }
}
