package adminPanel.getAndPrintAllUsers;

import EmployeeAccountingSystem.EmployeeEntities.Department;
import EmployeeAccountingSystem.EmployeeEntities.Employee;
import EmployeeAccountingSystem.EmployeeEntities.Gender;
import EmployeeAccountingSystem.EmployeeEntities.Job;
import authorization.Entities.User;
import constants.ConstOther;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GetAllUsers {
    private static ArrayList<String> tempFile;
    public static List<User> getUsers() throws FileNotFoundException {
        try {
            File folder = new File(ConstOther.FILE_PATH);
            File[] files = folder.listFiles();
            List<User> users = new ArrayList<>();
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
                User user = new User();
                user.setId(Long.valueOf(tempFile.get(0)));
                user.setLogin(tempFile.get(1));
                user.setPassword(tempFile.get(2));
                user.setEmail(tempFile.get(3));
                users.add(user);
            }
            return users;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
