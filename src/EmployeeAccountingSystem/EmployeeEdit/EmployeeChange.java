package EmployeeAccountingSystem.EmployeeEdit;

import EmployeeAccountingSystem.EmployeeEntities.Department;
import EmployeeAccountingSystem.EmployeeEntities.Employee;
import EmployeeAccountingSystem.EmployeeEntities.Gender;
import EmployeeAccountingSystem.EmployeeEntities.Job;
import EmployeeAccountingSystem.WorkWithFilesEmployee;
import constants.ConstOther;
import constants.ConstSample;
import generalMenu.EmployeeMenu;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class EmployeeChange {

    public static void changeStart() throws FileNotFoundException {
        Employee employee = find();
        changeMenu(employee);
    }
    public static void changeMenu(Employee employee) throws FileNotFoundException {

        System.out.println("\n\t-[ Выберите параметр для изменения работника ]-");
        System.out.println("\n\t[1] Фамилия" +
                "\n\t[2] Имя" +
                "\n\t[3] Отчество" +
                "\n\t[4] Пол" +
                "\n\t[5] Должность" +
                "\n\t[6] Название отдела" +
                "\n\t[7] Фамилия начальника" +
                "\n\t[8] Номер телефона" +
                "\n\t[0] Выход\n" +
                "\n\t[-1] Выбрать другого пользователя");

        int commandNumber = new Scanner(System.in).nextInt();

        switch (commandNumber){
            case 1 -> changeSurname(employee);
            case 2 -> changeName(employee);
            case 3 -> changePatronymic(employee);
            case 4 -> changeGender(employee);
            case 5 -> changeJob(employee);
            case 6 -> changeDepartment(employee);
            case 7 -> changeChiefSurname(employee);
            case 8 -> changePhone(employee);
            case 0 -> EmployeeMenu.menu();
            case -1 -> changeStart();
            default -> changeMenu(employee);
        }
    }

    public static void employeesBuild(Employee employee){
        EmployeeDelete.deleteEmployee(employee.getId());
        StringBuilder stringBuilder = new StringBuilder(employee.getId() + "\n" +
                employee.getName() + "\n" + employee.getSurname() + "\n" +
                employee.getPatronymic() + "\n" + employee.getDateOfBirth() + "\n" + employee.getGender() + "\n" +
                employee.getPhone() + "\n" + employee.getJobTitle() + "\n" + employee.getDepartment() + "\n" +
                employee.getSurnameOfTheChief() + "\n" + employee.getEmploymentDate() + "\n" + employee.getSalary());
        WorkWithFilesEmployee.write(stringBuilder, employee.getId());
    }

    public static void changeChiefSurname(Employee employee) throws FileNotFoundException{
        System.out.println("\n\t-[ выберите фамилию нового начальника для сотрудника ]-\n");
        EmployeeAdd.chief();
        if (employee.getJobTitle().equals(Job.DIRECTOR)){
            employee.setSurnameOfTheChief("There is not");
        }else if(!Objects.equals(employee.getJobTitle(), Job.DIRECTOR)) {
            int numberChief = new Scanner(System.in).nextInt();
            employee.setSurnameOfTheChief(EmployeeAdd.chiefSurname[numberChief - 1]);
        }
    }

    public static void changePhone(Employee employee) throws FileNotFoundException{
        System.out.println("\n\t-[ введите новый контактный телефон для сотрудника ]-\n");
        String phones = new Scanner(System.in).nextLine();
        if (!phones.matches(ConstSample.PHONE_TEMPLATE)){
            System.out.println("\n\t-[ Неверный формат (начните с 7)]-");
            changePhone(employee);
        }
        employee.setPhone(phones);

        employeesBuild(employee);
        changeMenu(employee);
    }

    public static void changeDepartment(Employee employee) throws FileNotFoundException{
        System.out.println("\n\t-[ выберите новое название отдела для сотрудника ]-\n");
        System.out.println("\n\t[1] Ремонтный отдел\n" +
                "\t[2] Научный отдел\n" +
                "\t[3] Технический отдел\n" +
                "\t[4] Отдел рекламы\n");
        int commandNumber =  new Scanner(System.in).nextInt();
        switch (commandNumber){
            case 1 -> employee.setDepartment(Department.REPAIR);
            case 2 -> employee.setDepartment(Department.SCIENTIFIC);
            case 3 -> employee.setDepartment(Department.TECHNICAL);
            case 4 -> employee.setDepartment(Department.ADVERTISING);
            default -> changeMenu(employee);
        }
        employeesBuild(employee);
        changeMenu(employee);
    }

    public static void changeJob(Employee employee)throws FileNotFoundException{
        System.out.println("\n\t-[ выберите новую должность сотрудника ]-\n");
        System.out.println("\n\t[1] Директор\n" +
                "\t[2] Заместитель директора\n" +
                "\t[3] Бухгалтер\n" +
                "\t[4] Диспетчер\n" +
                "\t[5] Менеджер\n" +
                "\t[6] Инженер\n" +
                "\t[7] Сварщик\n");
        int commandNumber =  new Scanner(System.in).nextInt();

        switch (commandNumber) {
            case 1 -> {
                employee.setJobTitle(Job.DIRECTOR);
                employee.setSalary(100000);
                employee.setSurnameOfTheChief("There is not");
            }
            case 2 -> {
                employee.setJobTitle(Job.DEPUTY_DIRECTOR);
                employee.setSalary(85000);
            }
            case 3 -> {
                employee.setJobTitle(Job.ACCOUNTANT);
                employee.setSalary(70000);
            }
            case 4 -> {
                employee.setJobTitle(Job.DISPATCHER);
                employee.setSalary(55000);
            }
            case 5 -> {
                employee.setJobTitle(Job.MANAGER);
                employee.setSalary(50000);
            }
            case 6 -> {
                employee.setJobTitle(Job.ENGINEER);
                employee.setSalary(40000);
            }
            case 7 -> {
                employee.setJobTitle(Job.WELDER);
                employee.setSalary(30000);
            }
            default -> changeMenu(employee);
        }

        employeesBuild(employee);
        changeMenu(employee);
    }
    public static void changeGender(Employee employee) throws FileNotFoundException{
        if (employee.getGender().equals(Gender.MALE)) employee.setGender(Gender.FEMALE);

        if (employee.getGender().equals(Gender.FEMALE)) employee.setGender(Gender.MALE);

        employeesBuild(employee);
        changeMenu(employee);
    }
    public static void changePatronymic(Employee employee) throws FileNotFoundException{
        System.out.println("\n\t-[ Введите новое отчество ]-");
        Scanner scanner = new Scanner(System.in);
        employee.setPatronymic(scanner.nextLine());
        employeesBuild(employee);
        changeMenu(employee);
    }
    public static void changeSurname(Employee employee) throws  FileNotFoundException{
        System.out.println("\n\t-[ Введите новую фамилию ]-");
        Scanner scanner = new Scanner(System.in);
        employee.setSurname(scanner.nextLine());
        employeesBuild(employee);
        changeMenu(employee);
    }

    public static void changeName(Employee employee) throws FileNotFoundException {
        System.out.println("\n\t-[ Введите новое имя ]-");
        Scanner scanner = new Scanner(System.in);
        employee.setName(scanner.nextLine());
        employeesBuild(employee);
        changeMenu(employee);
    }

    private static ArrayList<String> tempFile;
    public static Employee find(){
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
            return employee;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
