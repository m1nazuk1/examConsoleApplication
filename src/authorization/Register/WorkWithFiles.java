package authorization.Register;

import authorization.Entities.User;
import constants.ConstOther;

import java.io.*;
import java.util.ArrayList;

public class WorkWithFiles {
    public static int getFile() {
        int count = 0;
        File f = new File(ConstOther.FILE_PATH);
        File[] files = f.listFiles();

        if (files != null)
            for (int i = 0; i < files.length; i++) {
                count++;
                File file = files[i];
            }
        return count+1;
    }


    private ArrayList<String> tempFile;
    public User find(String id) {
        try {
            File folder = new File(ConstOther.FILE_PATH);
            File[] files = folder.listFiles();
            for (int i = 0; i < files.length; i++) {
                tempFile = new ArrayList<>();
                File file = files[i];
                FileReader fr = new FileReader(file);
                BufferedReader reader = new BufferedReader(fr);
                String line = reader.readLine();
                if (!line.equals(id)){
                    continue;
                }
                while (line != null) {
                    tempFile.add(line);
                    line = reader.readLine();
                }
                break;
            }
            User user = new User();
            user.setId(Long.valueOf((tempFile.get(0))));
            user.setLogin(tempFile.get(1));
            user.setPassword(tempFile.get(2));
            user.setEmail(tempFile.get(3));
            return user;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new User();
    }
}
