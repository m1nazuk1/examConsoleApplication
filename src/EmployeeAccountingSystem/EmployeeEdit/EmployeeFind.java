package EmployeeAccountingSystem.EmployeeEdit;

import EmployeeAccountingSystem.EmployeeEntities.Department;
import EmployeeAccountingSystem.EmployeeEntities.Employee;
import EmployeeAccountingSystem.EmployeeEntities.Gender;
import EmployeeAccountingSystem.EmployeeEntities.Job;
import EmployeeAccountingSystem.EmployeeGetsOrPrint.GetAllEmployee;
import constants.ConstOther;
import generalMenu.EmployeeMenu;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeFind {
    public static void findMenu() throws FileNotFoundException {
        System.out.println("\n\t-[ Выберите параметр для поиска работника ]-");
        System.out.println("\n\t[1] ID" +
                "\n\t[2] Фамилия" +
                "\n\t[3] Имя" +
                "\n\t[4] Отчество" +
                "\n\t[5] Пол" +
                "\n\t[6] Должность" +
                "\n\t[7] Название отдела" +
                "\n\t[8] Фамилия начальника" +
                "\n\t[9] Номер телефона" +
                "\n\t[0] Выход\n");
        Scanner scanner = new Scanner(System.in);
        int commandNumber = scanner.nextInt();

        switch (commandNumber){
            case 1 -> findWithId();
            case 2 -> findWithSurname();
            case 3 -> findWithName();
            case 4 -> findWithPatronymic();
            case 5 -> findWithGender();
            case 6 -> findWithJob();
            case 7 -> findWithDepartment();
            case 8 -> findWithChiefSurname();
            case 9 -> findWithPhoneNumber();
            case 0 -> EmployeeMenu.menu();
            default -> findMenu();
        }
    }

    public static void findWithChiefSurname() throws FileNotFoundException {
        System.out.println("\n\t-[ введите фамилию начальника для поиска ]-\n");
        String chiefName = new Scanner(System.in).nextLine();
        List<Employee> employeeList = GetAllEmployee.getEmployees();
        for (Employee a : employeeList) {
            if (a.getSurnameOfTheChief().equals(chiefName)) {
                System.out.println(a.toString());
            }
        }
        findMenu();
    }
    public static void findWithDepartment() throws FileNotFoundException {
        System.out.println("\n\t-[ Выберите название отдела для поиска ]-" +
                "\n\t[1] Ремонтный отдел\n" +
                "\t[2] Научный отдел\n" +
                "\t[3] Технический отдел\n" +
                "\t[4] Отдел рекламы\n");
        int department = new Scanner(System.in).nextInt();

        if (department == 1){
            List<Employee> employeeList = GetAllEmployee.getEmployees();
            for (Employee a : employeeList) {
                if (a.getDepartment().equals(Department.REPAIR)) {
                    System.out.println(a.toString());
                }
            }
        } else if (department == 2) {
            List<Employee> employeeList = GetAllEmployee.getEmployees();
            for (Employee a : employeeList) {
                if (a.getDepartment().equals(Department.SCIENTIFIC)) {
                    System.out.println(a.toString());
                }
            }
        } else if (department == 3) {
            List<Employee> employeeList = GetAllEmployee.getEmployees();
            for (Employee a : employeeList) {
                if (a.getDepartment().equals(Department.TECHNICAL)) {
                    System.out.println(a.toString());
                }
            }
        } else if (department == 4) {
            List<Employee> employeeList = GetAllEmployee.getEmployees();
            for (Employee a : employeeList) {
                if (a.getDepartment().equals(Department.ADVERTISING)) {
                    System.out.println(a.toString());
                }
            }
        }
        findMenu();

    }

    public static void findWithJob() throws FileNotFoundException {
        System.out.println("\n\t-[ Выберите должность для поиска ]-\n" +
                "\n\t[1] Директор" +
                "\n\t[2] Заместитель директора" +
                "\n\t[3] Бухгалтер" +
                "\n\t[4] Диспетчер" +
                "\n\t[5] Менеджер" +
                "\n\t[6] Инженер" +
                "\n\t[7] Сварщик\n");
        int job = new Scanner(System.in).nextInt();

        if (job == 1) {
            List<Employee> employeeList = GetAllEmployee.getEmployees();
            for (Employee a : employeeList) {
                if (a.getJobTitle().equals(Job.DIRECTOR)) {
                    System.out.println(a.toString());
                }
            }
        } else if (job == 2) {
            List<Employee> employeeList = GetAllEmployee.getEmployees();
            for (Employee a : employeeList) {
                if (a.getJobTitle().equals(Job.DEPUTY_DIRECTOR)) {
                    System.out.println(a.toString());
                }
            }
        } else if (job == 3) {
            List<Employee> employeeList = GetAllEmployee.getEmployees();
            for (Employee a : employeeList) {
                if (a.getJobTitle().equals(Job.ACCOUNTANT)) {
                    System.out.println(a.toString());
                }
            }
        } else if (job == 4) {
            List<Employee> employeeList = GetAllEmployee.getEmployees();
            for (Employee a : employeeList) {
                if (a.getJobTitle().equals(Job.DISPATCHER)) {
                    System.out.println(a.toString());
                }
            }
        } else if (job == 5) {
            List<Employee> employeeList = GetAllEmployee.getEmployees();
            for (Employee a : employeeList) {
                if (a.getJobTitle().equals(Job.MANAGER)) {
                    System.out.println(a.toString());
                }
            }
        } else if (job == 6) {
            List<Employee> employeeList = GetAllEmployee.getEmployees();
            for (Employee a : employeeList) {
                if (a.getJobTitle().equals(Job.ENGINEER)) {
                    System.out.println(a.toString());
                }
            }
        } else if (job == 7) {
            List<Employee> employeeList = GetAllEmployee.getEmployees();
            for (Employee a : employeeList) {
                if (a.getJobTitle().equals(Job.WELDER)) {
                    System.out.println(a.toString());
                }
            }
        }
        findMenu();

    }

    private static ArrayList<String> tempFile;
    public static void findWithId() throws FileNotFoundException {
        System.out.println("\n\t-[ Введите ID для поиска ]-\n");
        String id = new Scanner(System.in).nextLine();
        try {
            File folder = new File(ConstOther.FILE_PATH_EMPLOYEES);
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
            System.out.println(employee);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        findMenu();
    }



    public static void findWithSurname() throws FileNotFoundException {
//        try {
//            File folder = new File(ConstOther.filePathEmployees);
//            File[] files = folder.listFiles();
//            for (int i = 0; i < files.length; i++) {
//                tempFile1 = new ArrayList<>();
//                File file = files[i];
//                FileReader fr = new FileReader(file);
//                BufferedReader reader = new BufferedReader(fr);
//                String line = reader.readLine();
//                if (!line.equals(surname)){
//                    continue;
//                }
//                while (line != null) {
//                    tempFile1.add(line);
//                    line = reader.readLine();
//                }
//                break;
//            }
//            System.out.println(tempFile1);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        System.out.println("\n\t-[ Введите фамилию для поиска ]-\n");
        String surname = new Scanner(System.in).nextLine();
        List<Employee> employeeList = GetAllEmployee.getEmployees();
        for (Employee a : employeeList){
            if (a.getSurname().equals(surname)){
                System.out.println(a.toString());
            }
        }
        findMenu();
    }

    public static void findWithPhoneNumber() throws FileNotFoundException {
        System.out.println("\n\t-[ Введите номер для поиска ]-\n");
        String phone = new Scanner(System.in).nextLine();
        List<Employee> employeeList = GetAllEmployee.getEmployees();
        for (Employee a : employeeList){
            if (a.getPhone().equals(phone)){
                System.out.println(a.toString());
            }
        }
        findMenu();
    }

    public static void findWithName() throws FileNotFoundException {
        System.out.println("\n\t-[ Введите имя для поиска ]-\n");
        String name = new Scanner(System.in).nextLine();
        List<Employee> employeeList = GetAllEmployee.getEmployees();
        for (Employee a : employeeList){
            if (a.getName().equals(name)){
                System.out.println(a.toString());
            }
        }
        findMenu();
    }

    public static void findWithPatronymic() throws FileNotFoundException {
        System.out.println("\n\t-[ Введите отчество для поиска ]-\n");
        String patronymic = new Scanner(System.in).nextLine();
        List<Employee> employeeList = GetAllEmployee.getEmployees();
        for (Employee a : employeeList){
            if (a.getPatronymic().equals(patronymic)){
                System.out.println(a.toString());
            }
        }
        findMenu();
    }

    public static void findWithGender() throws FileNotFoundException {
        System.out.println("\n\t-[ Выберите пол для поиска ]-\n" +
                "\n\t[1] мужской" +
                "\n\t[2] женский");
        int gender = new Scanner(System.in).nextInt();

        if (gender == 1){
            List<Employee> employeeList = GetAllEmployee.getEmployees();
            for (Employee a : employeeList){
                if (a.getGender().equals(Gender.MALE)){
                    System.out.println(a.toString());
                }
            }
        }else if(gender == 2){
            List<Employee> employeeList = GetAllEmployee.getEmployees();
            for (Employee a : employeeList){
                if (a.getGender().equals(Gender.FEMALE)){
                    System.out.println(a.toString());
                }
            }
        }
        findMenu();
    }
}
