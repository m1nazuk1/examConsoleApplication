package CollectionOfTextDocuments.DocumentsEdit;

import CollectionOfTextDocuments.workWithFiles.DeleteFile;
import EmployeeAccountingSystem.EmployeeEntities.Employee;
import EmployeeAccountingSystem.EmployeeGetsOrPrint.GetAllEmployee;
import generalMenu.CollectionOfTextDocumentsMenu;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class DeleteAllNotes {
    public static void deleteAll(){
        System.out.println("\n\t-[ чьи заметку вы хотите удалить? ]-");
        List<Employee> employees;
        try {
            employees = GetAllEmployee.getEmployees();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        int j = employees.size()-1;
        for (int i = 0; i < employees.size(); i++) {
            System.out.println("\t[" + employees.get(j).getId() + "] " + employees.get(j).getName()
                    + " " + employees.get(j).getSurname() + " " + employees.get(j).getPatronymic());
            j--;
        }
        long idEx = new Scanner(System.in).nextLong();

        long id = 0;
        for (Employee employee : employees){
            if (employee.getId().equals(idEx)){
                id = employee.getId();
            }
        }

        DeleteFile.delete(id);

        CollectionOfTextDocumentsMenu.menu();
    }
}
