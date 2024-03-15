package CollectionOfTextDocuments.workWithFiles;

import adminPanel.AdminMenu;
import constants.ConstOther;
import generalMenu.CollectionOfTextDocumentsMenu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DeleteFile {

    public static void delete(Long id){
        File folder = new File(ConstOther.FILE_PATH_NOTES_TXT + id + ".txt");
        File folder2 = new File(ConstOther.FILE_PATH_EXCEL_NOTES + id + "temp.xlsx");
        folder.delete();
        folder2.delete();
    }
}
