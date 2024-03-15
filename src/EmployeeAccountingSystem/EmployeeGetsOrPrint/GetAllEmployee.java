package EmployeeAccountingSystem.EmployeeGetsOrPrint;

import EmployeeAccountingSystem.EmployeeEntities.Department;
import EmployeeAccountingSystem.EmployeeEntities.Employee;
import EmployeeAccountingSystem.EmployeeEntities.Gender;
import EmployeeAccountingSystem.EmployeeEntities.Job;
import constants.ConstOther;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GetAllEmployee {
    private static ArrayList<String> tempFile;
    public static List<Employee> getEmployees() throws FileNotFoundException{
            try {
                File folder = new File(ConstOther.FILE_PATH_EMPLOYEES);
                File[] files = folder.listFiles();
                List<Employee> employees = new ArrayList<>();
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
                    Employee employee = new Employee();
                    employee.setId(Long.valueOf((tempFile.get(0))));
                    employee.setName(tempFile.get(1));
                    employee.setSurname(tempFile.get(2));
                    employee.setPatronymic(tempFile.get(3));
                    employee.setDateOfBirth(LocalDate.parse(tempFile.get(4)));
                    employee.setGender(Gender.valueOf(tempFile.get(5)));
                    employee.setPhone(tempFile.get(6));
                    employee.setJobTitle(Job.valueOf(tempFile.get(7)));
                    employee.setDepartment(Department.valueOf(tempFile.get(8)));
                    employee.setSurnameOfTheChief(tempFile.get(9));
                    employee.setEmploymentDate(LocalDate.parse(tempFile.get(10)));
                    employee.setSalary(Integer.parseInt(tempFile.get(11)));
                    employees.add(employee);
                }
                return employees;
            } catch (IOException e) {
                throw new RuntimeException(e);
        }
    }
}
