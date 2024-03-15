package FinanceAccountingSystem;

import constants.ConstOther;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WorkWithFilesFinanceAccount {
    public static void write(String text, Long id) {

        try(FileWriter writer = new FileWriter(ConstOther.FILE_PATH_CARDS + id + ".txt", false))
        {
            writer.write(text);
            writer.flush();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public static int getFile() {
        int count = 0;
        File f = new File(ConstOther.FILE_PATH_CARDS);
        File[] files = f.listFiles();

        if (files != null)
            for (int i = 0; i < files.length; i++) {
                count++;
                File file = files[i];
            }
        return count+1;
    }
}
