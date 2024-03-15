package CollectionOfTextDocuments.DocumentsEdit;

import CollectionOfTextDocuments.getAllNotes.GetsNotes;
import CollectionOfTextDocuments.workWithFiles.ReadFile;
import constants.ConstOther;
import generalMenu.CollectionOfTextDocumentsMenu;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindNotes {
    public static void find(){
        List<List<String>> list = GetsNotes.getAllNotes();
        System.out.println("\n\t-[ введите заметку, которую хотите найти ]-");
        String notes = new Scanner(System.in).nextLine();

        File folder = new File(ConstOther.FILE_PATH_FOLDER_NOTES_TXT);
        File[] files = folder.listFiles();
        List<List<String>> allNotes = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            allNotes.add(ReadFile.read(files[i].getAbsolutePath()));
        }
        String res = "";
        for (List<String> e : allNotes){
            for (int i = 0; i < e.size(); i++) {
                if (e.get(i).contains(notes)){
                    res = e.get(0);
                }
            }
        }

        System.out.println("\n\t-[ данная заметка принадлежит " + res + " ]-\n");

        CollectionOfTextDocumentsMenu.menu();
    }
}
