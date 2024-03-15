package authorization.Register;

import constants.ConstOther;

import java.io.*;

public class Registration {
    public static void write(StringBuilder text, Long fileName) {

        try(FileWriter writer = new FileWriter(ConstOther.FILE_PATH + fileName + ".txt", false))
        {
            writer.write(String.valueOf(text));
            writer.flush();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
