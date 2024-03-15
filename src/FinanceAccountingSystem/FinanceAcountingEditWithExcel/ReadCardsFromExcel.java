package FinanceAccountingSystem.FinanceAcountingEditWithExcel;

import EmployeeAccountingSystem.EmployeeEntities.Department;
import EmployeeAccountingSystem.EmployeeEntities.Employee;
import EmployeeAccountingSystem.EmployeeEntities.Gender;
import EmployeeAccountingSystem.EmployeeEntities.Job;
import FinanceAccountingSystem.financeEntities.FinanceAccount;
import generalMenu.EmployeeMenu;
import generalMenu.FinanceAccountingSystemMenu;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReadCardsFromExcel {
    public static List<FinanceAccount> readExcel(String fileLocation) throws IOException {
        FileInputStream file = new FileInputStream(new File(fileLocation));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        List<FinanceAccount> list = new ArrayList<>();
        int i = 0;
        for (Row row : sheet) {
            FinanceAccount data = new FinanceAccount();
            for (Cell cell : row) {
                if (i != 0) {
                    switch (cell.getColumnIndex()) {
                        case 0 -> {
                            data.setId((long) cell.getNumericCellValue());
                        }
                        case 1 -> {
                            data.setName(cell.getRichStringCellValue().getString());
                        }
                        case 2 -> {
                            data.setSurname(cell.getRichStringCellValue().getString());
                        }
                        case 3 -> {
                            data.setPatronymic(cell.getRichStringCellValue().getString());
                        }
                        case 4 -> {
                            String[] components = cell.getRichStringCellValue().getString().split("-");
                            String day = components[2];
                            String month = components[1];
                            String year = components[0];
                            LocalDate newDate = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
                            data.setDateOfBirth(newDate);
                        }
                        case 5 -> {
                            data.setGender(Gender.valueOf(cell.getRichStringCellValue().getString()));
                        }
                        case 6 -> {
                            data.setPhone(String.valueOf(cell.getNumericCellValue()));
                        }
                        case 7 -> {
                            data.setJobTitle(Job.valueOf(cell.getRichStringCellValue().getString()));
                        }
                        case 8 -> {
                            data.setDepartment(Department.valueOf(cell.getRichStringCellValue().getString()));
                        }
                        case 9 -> {
                            data.setSurnameOfTheChief(cell.getRichStringCellValue().getString());
                        }
                        case 10 -> {
                            String[] components = cell.getRichStringCellValue().getString().split("-");
                            String day = components[2];
                            String month = components[1];
                            String year = components[0];
                            LocalDate newDate = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
                            data.setEmploymentDate(newDate);
                        }
                        case 11 -> {
                            data.setSalary((int) cell.getNumericCellValue());
                        }
                        case 12 -> {
                            data.setNameOfCard(cell.getRichStringCellValue().getString());
                        }
                        case 13 -> {
                            data.setNumberOfCard((int) cell.getNumericCellValue());
                        }
                        case 14 -> {
                            data.setNameOfThePotentialCost(cell.getRichStringCellValue().getString());
                        }
                        case 15 -> {
                            data.setPotentialCost((int) cell.getNumericCellValue());
                        }
                        case 16 -> {
                            data.setCurrentCostName(cell.getRichStringCellValue().getString());
                        }
                        case 17 -> {
                            data.setCurrentCost((int) cell.getNumericCellValue());
                        }
                        case 18 -> {
                            data.setNamePotentialIncome(cell.getRichStringCellValue().getString());
                        }
                        case 19 -> {
                            data.setPotentialIncome((int) cell.getNumericCellValue());
                        }
                    }
                }
            }
            if (i != 0) list.add(data);
            i++;
        }
        return list;

    }
}
