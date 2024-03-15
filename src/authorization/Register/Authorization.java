package authorization.Register;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Authorization {

    public static boolean admin(String login, String password){
        try {
            File folder = new File("src/resources/entities/admin");
            File[] files = folder.listFiles();
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
                if(tempFile.get(1).equals(login) && tempFile.get(2).equals(password)){
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    private static ArrayList <String> tempFile;
    public static Boolean auth(String login, String password) {
        try {
            File folder = new File("src/resources/entities/users");
            File[] files = folder.listFiles();
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
                if(tempFile.get(1).equals(login) && tempFile.get(2).equals(password)){
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
