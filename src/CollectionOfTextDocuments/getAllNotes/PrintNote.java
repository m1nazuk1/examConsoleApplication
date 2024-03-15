package CollectionOfTextDocuments.getAllNotes;

import EmployeeAccountingSystem.EmployeeEntities.Employee;
import EmployeeAccountingSystem.EmployeeGetsOrPrint.GetAllEmployee;
import generalMenu.CollectionOfTextDocumentsMenu;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class PrintNote {
    public static void print() {
        System.out.println("\n\t-[ чью заметку вы хотите вывести? ]-");
        List<Employee> employees;
        try {
            employees = GetAllEmployee.getEmployees();
        } catch (
                FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        int j = employees.size()-1;
        for (int i = 0; i < employees.size(); i++) {
            System.out.println("\t[" + employees.get(j).getId() + "] " + employees.get(j).getName()
                    + " " + employees.get(j).getSurname() + " " + employees.get(j).getPatronymic());
            j--;
        }
        long id = new Scanner(System.in).nextLong();

        String name = "";
        for (Employee e : employees){
            if (e.getId() == id){
                name = e.getName() + " " + e.getSurname();
            }
        }

        List<List<String>> list = GetsNotes.getAllNotes();
        int i = 0;
        for (List<String> a : list){
            if (a.get(0).equals(name)){
                System.out.println(list.get(i));
            }
            i++;
        }

        CollectionOfTextDocumentsMenu.menu();
    }
}
