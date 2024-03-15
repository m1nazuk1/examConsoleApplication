package EmployeeAccountingSystem.EmployeeEdit;

import EmployeeAccountingSystem.EmployeeEntities.Department;
import EmployeeAccountingSystem.EmployeeEntities.Employee;
import EmployeeAccountingSystem.EmployeeEntities.Gender;
import EmployeeAccountingSystem.EmployeeEntities.Job;
import EmployeeAccountingSystem.EmployeeGetsOrPrint.GetAllEmployee;
import EmployeeAccountingSystem.WorkWithFilesEmployee;
import constants.ConstSample;
import generalMenu.EmployeeMenu;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class EmployeeAdd {
    public static String[] chiefSurname = new String[5];
    public static void addingAnEmployee() throws FileNotFoundException {
        int commandNumber;
        Scanner scanner = new Scanner(System.in);
        Employee employee = new Employee();
        System.out.println("\n\t-[ введите имя нового сотрудника ]-\n");
        employee.setName(scanner.nextLine());
        System.out.println("\n\t-[ введите фамилию нового сотрудника ]-\n");
        employee.setSurname(scanner.nextLine());
        System.out.println("\n\t-[ введите отчество нового сотрудника ]-\n");
        employee.setPatronymic(scanner.nextLine());
        System.out.println("\n\t-[ введите дату рождения нового сотрудника (в формате: день месяц год) ]-\n");
        employee.setDateOfBirth(date());
        System.out.println("\n\t-[ выберите пол нового сотрудника ]-\n");
        System.out.println("\n\t[1] мужской\n" +
                "\t[2] женский\n");
        commandNumber = scanner.nextInt();
        switch (commandNumber){
            case 1 -> employee.setGender(Gender.MALE);
            case 2 -> employee.setGender(Gender.FEMALE);
            default -> addingAnEmployee();
        }
        System.out.println("\n\t-[ введите контактный телефон нового сотрудника ]-\n");
        String phones = new Scanner(System.in).nextLine();
        if (!phones.matches(ConstSample.PHONE_TEMPLATE)){
            System.out.println("\n\t-[ Неверный формат (начните с 7)]-");
            addingAnEmployee();
        }
        employee.setPhone(phones);

        System.out.println("\n\t-[ выберите должность нового сотрудника ]-\n");
        System.out.println("\n\t[1] Директор\n" +
                "\t[2] Заместитель директора\n" +
                "\t[3] Бухгалтер\n" +
                "\t[4] Диспетчер\n" +
                "\t[5] Менеджер\n" +
                "\t[6] Инженер\n" +
                "\t[7] Сварщик\n");
        commandNumber = scanner.nextInt();

        switch (commandNumber){
            case 1 -> {
                employee.setJobTitle(Job.DIRECTOR);
                employee.setSalary(100000);
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
            default -> addingAnEmployee();
        }


        System.out.println("\n\t-[ выберите название отдела нового сотрудника ]-\n");
        System.out.println("\n\t[1] Ремонтный отдел\n" +
                "\t[2] Научный отдел\n" +
                "\t[3] Технический отдел\n" +
                "\t[4] Отдел рекламы\n");
        commandNumber = scanner.nextInt();
        switch (commandNumber){
            case 1 -> employee.setDepartment(Department.REPAIR);
            case 2 -> employee.setDepartment(Department.SCIENTIFIC);
            case 3 -> employee.setDepartment(Department.TECHNICAL);
            case 4 -> employee.setDepartment(Department.ADVERTISING);
            default -> addingAnEmployee();
        }


        if (employee.getJobTitle().equals(Job.DIRECTOR)){
            employee.setSurnameOfTheChief("There is not");
        }else if(!Objects.equals(employee.getJobTitle(), Job.DIRECTOR)) {
            System.out.println("\n\t-[ выберите фамилию начальника нового сотрудника ]-\n");
            chief();
            int numberChief = new Scanner(System.in).nextInt();
            employee.setSurnameOfTheChief(chiefSurname[numberChief - 1]);
        }

        System.out.println("\n\t-[ введите дату приема на работу нового сотрудника ]-\n");
        employee.setEmploymentDate(date());

        employee.setId((long) WorkWithFilesEmployee.getFile());
        StringBuilder stringBuilder = new StringBuilder(employee.getId() + "\n" +
                employee.getName() + "\n" + employee.getSurname() + "\n" +
                employee.getPatronymic() + "\n" + employee.getDateOfBirth() + "\n" + employee.getGender() + "\n" +
                employee.getPhone() + "\n" + employee.getJobTitle() + "\n" + employee.getDepartment() + "\n" +
                employee.getSurnameOfTheChief() + "\n" + employee.getEmploymentDate() + "\n" + employee.getSalary());
        WorkWithFilesEmployee.write(stringBuilder, employee.getId());

        EmployeeMenu.menu();
    }

    public static int counter = 0;

    public static void chief() throws FileNotFoundException {
        List<Employee> employeeList = GetAllEmployee.getEmployees();
        int i = 0;
        for (Employee a : employeeList){
            if (a.getJobTitle().equals(Job.DIRECTOR)){
                chiefSurname[i] = a.getSurname();
                i++;
            }
        }
        counter = i;
        for (int j = 0; j < i; j++){
            System.out.println("\n\t[" + (j+1) + "]" + chiefSurname[j]);
        }
        System.out.println("\n");
    }

    public static LocalDate date(){
        LocalDate newDate = null;
        String data = new Scanner(System.in).nextLine();

        String[] components = data.split("\\s+");
        if (components.length != 3) {
            System.out.println("\n\t-[ Неверный формат ]-");
            date();
        }else {
            String day = components[ConstSample.INDEX_DAY];
            if (!day.matches(ConstSample.DAY_TEMPLATE) || (Integer.parseInt(day) > 31)) {
                System.out.println("\n\t-[ Неверный формат дня в строке " + day + " ]-\n");
                date();
            }else{
                String month = components[ConstSample.INDEX_MONTH];
                if ((!month.matches(ConstSample.MONTH_TEMPLATE)) || (Integer.parseInt(month) > 12)) {
                    System.out.println("\n\t-[ Неверный формат месяца в строке " + month + " ]-\n");
                    date();
                }else {
                    String year = components[ConstSample.INDEX_YEAR];
                    if (!year.matches(ConstSample.YEAR_TEMPLATE) || (Integer.parseInt(year) > 2023) || (Integer.parseInt(year) < 1900)){
                        System.out.println("\n\t-[ Неверный формат года в строке " + year + "]-\n");
                        date();
                    }else {
                        newDate = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
                    }
                }
            }
        }
        return newDate;
    }



}
