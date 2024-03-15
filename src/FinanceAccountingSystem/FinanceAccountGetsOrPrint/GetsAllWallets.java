package FinanceAccountingSystem.FinanceAccountGetsOrPrint;

import EmployeeAccountingSystem.EmployeeEntities.Department;
import EmployeeAccountingSystem.EmployeeEntities.Employee;
import EmployeeAccountingSystem.EmployeeEntities.Gender;
import EmployeeAccountingSystem.EmployeeEntities.Job;
import FinanceAccountingSystem.financeEntities.FinanceAccount;
import constants.ConstOther;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GetsAllWallets {
    private static List<String> tempFile;
    public static List<FinanceAccount> getAllWallet(){
        try {
            File folder = new File(ConstOther.FILE_PATH_CARDS);
            File[] files = folder.listFiles();
            List<FinanceAccount> financeAccounts = new ArrayList<>();
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
                String[] components1 = tempFile.get(1).split(" : ");
                String[] components2 = tempFile.get(2).split(" : ");
                String[] components3 = tempFile.get(3).split(" : ");
                String[] components4 = tempFile.get(4).split(" : ");

                FinanceAccount financeAccount = new FinanceAccount();
                financeAccount.setId(Long.valueOf(tempFile.get(0)));
                financeAccount.setNameOfCard(components1[0]);
                financeAccount.setNumberOfCard(Integer.parseInt(components1[1]));
                financeAccount.setNameOfThePotentialCost(components2[0]);
                financeAccount.setPotentialCost(Integer.parseInt(components2[1]));
                financeAccount.setCurrentCostName(components3[0]);
                financeAccount.setCurrentCost(Integer.parseInt(components3[1]));
                financeAccount.setNamePotentialIncome(components4[0]);
                financeAccount.setPotentialIncome(Integer.parseInt(components4[1]));
                financeAccounts.add(financeAccount);
            }
            return financeAccounts;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
