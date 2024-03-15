package EmployeeAccountingSystem;

import constants.ConstOther;

import java.io.*;

public class WorkWithFilesEmployee {
    public static void write(StringBuilder text, Long id) {

        try(FileWriter writer = new FileWriter(ConstOther.FILE_PATH_EMPLOYEES + id + ".txt", false))
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
        File f = new File(ConstOther.FILE_PATH_EMPLOYEES);
        File[] files = f.listFiles();

        if (files != null)
            for (int i = 0; i < files.length; i++) {
                count++;
                File file = files[i];
            }
        return count+1;
    }

}
