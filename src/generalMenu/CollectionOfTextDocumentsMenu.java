package generalMenu;

import CollectionOfTextDocuments.DocumentsEdit.*;
import CollectionOfTextDocuments.getAllNotes.PrintNote;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class CollectionOfTextDocumentsMenu {
    public static void menu(){
        System.out.println("\n\t[1] создание заметки" +
                "\n\t[2] изменение заметки" +
                "\n\t[3] вывод заметки" +
                "\n\t[4] удаление заметки" +
                "\n\t[5] поиск по заметкам" +
                "\n\t[6] удаление всех заметов у работника" +
                "\n\t[0] выход\n");

        int commandNumber = new Scanner(System.in).nextInt();
        switch (commandNumber){
            case 1 -> {
                AddNotes.add();
            }
            case 2 -> {
                EditNotes.edit();
            }
            case 3 -> {
                PrintNote.print();
            }
            case 4 -> {
                DeleteNotes.edit();
            }
            case 5 -> {
                FindNotes.find();
            }
            case 6 -> {
                DeleteAllNotes.deleteAll();
            }
            case 0 -> {
                try {
                    MyMenu.menu();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            default -> menu();
        }
    }
}
