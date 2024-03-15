package CollectionOfTextDocuments.getAllNotes;

import FinanceAccountingSystem.financeEntities.FinanceAccount;
import constants.ConstOther;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetsNotes {
    private static List<String> tempFile;
    public static List<List<String>> getAllNotes() {
        try {
            File folder = new File(ConstOther.FILE_PATH_NOTES_TXT);
            File[] files = folder.listFiles();
            List<List<String>> list = new ArrayList<>();
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
                list.add(tempFile);
            }
            return list;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
