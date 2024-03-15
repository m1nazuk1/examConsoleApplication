package FinanceAccountingSystem.FinanceAccountEdit;

import EmployeeAccountingSystem.EmployeeEntities.Employee;
import EmployeeAccountingSystem.EmployeeGetsOrPrint.GetAllEmployee;
import FinanceAccountingSystem.WorkWithFilesFinanceAccount;
import FinanceAccountingSystem.financeEntities.FinanceAccount;
import generalMenu.FinanceAccountingSystemMenu;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddWallets {
    public static void add(){
        System.out.println("\n\t-[ к кому вы хотите привязать карту? ]-\n");
        List<Employee> employeeList;
        try {
            employeeList = GetAllEmployee.getEmployees();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < employeeList.size(); i++) {
            System.out.println("[" + (i+1) + "]" + employeeList.get(i).getName());
        }
        int commandNumber = new Scanner(System.in).nextInt();

        FinanceAccount financeAccount = new FinanceAccount();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\t-[ введите название карты ]-\n");
        String nameOfCard = scanner.nextLine();
        System.out.println("\n\t-[ вот ваш номер карты ]-\n");
        int numberOfCard = (int)( 999999 + Math.random()* 9999999);
        System.out.println(numberOfCard);
        System.out.println("\n\t-[ введите название потенциальных затрат ]-\n");
        String nameOfThePotentialCost = scanner.nextLine();
        System.out.println("\n\t-[ введите сумму потенциальных затрат ]-\n");
        int potentialCost = scanner.nextInt();
        System.out.println("\n\t-[ введите название текущих затрат ]-\n");
        String nameOfCurrentCosts = new Scanner(System.in).nextLine();
        System.out.println("\n\t-[ введите сумму текущих затрат ]-\n");
        int currentCosts = new Scanner(System.in).nextInt();
        System.out.println("\n\t-[ введите название потенциального дохода ]-\n");
        String nameOfPotentialIncome = new Scanner(System.in).nextLine();
        System.out.println("\n\t-[ введите сумму потеньциального дохода ]-\n");
        int potentialIncome = new Scanner(System.in).nextInt();

        financeAccount.setId(employeeList.get(commandNumber-1).getId());
        financeAccount.setNameOfCard(nameOfCard);
        financeAccount.setNumberOfCard(numberOfCard);
        financeAccount.setNameOfThePotentialCost(nameOfThePotentialCost);
        financeAccount.setPotentialCost(potentialCost);
        financeAccount.setCurrentCostName(nameOfCurrentCosts);
        financeAccount.setCurrentCost(currentCosts);
        financeAccount.setNamePotentialIncome(nameOfPotentialIncome);
        financeAccount.setPotentialIncome(potentialIncome);

        ArrayList<FinanceAccount> arrayList = new ArrayList<>();
        arrayList.add(financeAccount);
        WorkWithFilesFinanceAccount.write(financeAccount.toString(), financeAccount.getId());

        FinanceAccountingSystemMenu.menu();
    }
}
