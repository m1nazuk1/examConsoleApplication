package bookStore;

import constants.ConstOther;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WorkWithFilesBooks {
    public static void write(String text, String name) {

        try(FileWriter writer = new FileWriter(ConstOther.FILE_PATH_BOOKS + name + ".txt", false))
        {
            writer.write(String.valueOf(text));
            writer.flush();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public static int getFile() {
        int count = 0;
        File f = new File(ConstOther.FILE_PATH_BOOKS);
        File[] files = f.listFiles();

        if (files != null)
            for (int i = 0; i < files.length; i++) {
                count++;
            }
        return count+1;
    }

    public static void deleteBooks(String name){
        File folder = new File(ConstOther.FILE_PATH_BOOKS + name + ".txt");
        folder.delete();
    }
}
