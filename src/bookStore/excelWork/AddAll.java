package bookStore.excelWork;

import EmployeeAccountingSystem.EmployeeEntities.Employee;
import FinanceAccountingSystem.financeEntities.FinanceAccount;
import bookStore.bookEntities.Book;
import generalMenu.FinanceAccountingSystemMenu;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class AddAll {
    public static void add(String file, List<FinanceAccount> listCard, List<Employee> list, List<Book> listBook, int numberBook, long numberEmployee){
        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("Persons");
        sheet.setColumnWidth(0, 6000);
        sheet.setColumnWidth(1, 6000);
        sheet.setColumnWidth(2, 6000);
        sheet.setColumnWidth(3, 6000);
        sheet.setColumnWidth(4, 6000);
        sheet.setColumnWidth(5, 6000);
        sheet.setColumnWidth(6, 6000);
        sheet.setColumnWidth(7, 6000);
        sheet.setColumnWidth(8, 6000);
        sheet.setColumnWidth(9, 6000);
        sheet.setColumnWidth(10, 6000);
        sheet.setColumnWidth(11, 6000);
        sheet.setColumnWidth(12, 6000);
        sheet.setColumnWidth(13, 6000);
        sheet.setColumnWidth(14, 6000);
        sheet.setColumnWidth(15, 6000);
        sheet.setColumnWidth(16, 6000);
        sheet.setColumnWidth(17, 6000);
        sheet.setColumnWidth(18, 6000);
        sheet.setColumnWidth(19, 6000);
        sheet.setColumnWidth(20, 6000);

        Row header = sheet.createRow(0);

        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName("Arial");
        font.setFontHeightInPoints((short) 16);
        font.setBold(true);
        headerStyle.setFont(font);

        Cell headerCell = header.createCell(0);
        headerCell.setCellValue("id");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(1);
        headerCell.setCellValue("name");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(2);
        headerCell.setCellValue("surname");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(3);
        headerCell.setCellValue("patronymic");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(4);
        headerCell.setCellValue("date of birth");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(5);
        headerCell.setCellValue("gender");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(6);
        headerCell.setCellValue("phone");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(7);
        headerCell.setCellValue("job title");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(8);
        headerCell.setCellValue("department");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(9);
        headerCell.setCellValue("Chief surname");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(10);
        headerCell.setCellValue("employment date");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(11);
        headerCell.setCellValue("salary");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(12);
        headerCell.setCellValue("name of card");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(13);
        headerCell.setCellValue("number of card");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(14);
        headerCell.setCellValue("name of the potential cost");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(15);
        headerCell.setCellValue("potential cost");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(16);
        headerCell.setCellValue("current cost name");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(17);
        headerCell.setCellValue("current cost");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(18);
        headerCell.setCellValue("name potential income");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(19);
        headerCell.setCellValue("potential income");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(20);
        headerCell.setCellValue("favorite book");
        headerCell.setCellStyle(headerStyle);

        int i = list.size()-1;
        for (int j = 0; j < list.size(); j++) {
            CellStyle style = workbook.createCellStyle();
            style.setWrapText(true);

            Row row = sheet.createRow(j+1);
            Cell cell = row.createCell(0);
            cell.setCellValue(list.get(i).getId());
            cell.setCellStyle(style);

            if (list.get(j).getId().equals(numberEmployee)){
                cell = row.createCell(20);
                cell.setCellValue(listBook.get(numberBook).getTitle());
                cell.setCellStyle(style);
            }

            cell = row.createCell(1);
            cell.setCellValue(list.get(i).getName());
            cell.setCellStyle(style);

            cell = row.createCell(2);
            cell.setCellValue(list.get(i).getSurname());
            cell.setCellStyle(style);

            cell = row.createCell(3);
            cell.setCellValue(list.get(i).getPatronymic());
            cell.setCellStyle(style);

            cell = row.createCell(4);
            cell.setCellValue(list.get(i).getDateOfBirth().toString());
            cell.setCellStyle(style);

            cell = row.createCell(5);
            cell.setCellValue(list.get(i).getGender().toString());
            cell.setCellStyle(style);

            cell = row.createCell(6);
            cell.setCellValue(Double.parseDouble(list.get(i).getPhone()));
            cell.setCellStyle(style);

            cell = row.createCell(7);
            cell.setCellValue(list.get(i).getJobTitle().toString());
            cell.setCellStyle(style);

            cell = row.createCell(8);
            cell.setCellValue(list.get(i).getDepartment().toString());
            cell.setCellStyle(style);

            cell = row.createCell(9);
            cell.setCellValue(list.get(i).getSurnameOfTheChief());
            cell.setCellStyle(style);

            cell = row.createCell(10);
            cell.setCellValue(list.get(i).getEmploymentDate().toString());
            cell.setCellStyle(style);

            cell = row.createCell(11);
            cell.setCellValue(list.get(i).getSalary());
            cell.setCellStyle(style);

            for (int k = 0; k < listCard.size(); k++) {
                if (list.get(i).getId().equals(listCard.get(k).getId())){
                    cell = row.createCell(12);
                    cell.setCellValue(listCard.get(k).getNameOfCard());
                    cell.setCellStyle(style);

                    cell = row.createCell(13);
                    cell.setCellValue(listCard.get(k).getNumberOfCard());
                    cell.setCellStyle(style);

                    cell = row.createCell(14);
                    cell.setCellValue(listCard.get(k).getNameOfThePotentialCost());
                    cell.setCellStyle(style);

                    cell = row.createCell(15);
                    cell.setCellValue(listCard.get(k).getPotentialCost());
                    cell.setCellStyle(style);

                    cell = row.createCell(16);
                    cell.setCellValue(listCard.get(k).getCurrentCostName());
                    cell.setCellStyle(style);

                    cell = row.createCell(17);
                    cell.setCellValue(listCard.get(k).getCurrentCost());
                    cell.setCellStyle(style);

                    cell = row.createCell(18);
                    cell.setCellValue(listCard.get(k).getNamePotentialIncome());
                    cell.setCellStyle(style);

                    cell = row.createCell(19);
                    cell.setCellValue(listCard.get(k).getPotentialIncome());
                    cell.setCellStyle(style);
                }

            }



            i--;
        }

        File currDir = new File(file);
        String path = currDir.getAbsolutePath();
        String fileLocation = path.substring(0, path.length() - 1) + "temp.xlsx";

        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(fileLocation);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FinanceAccountingSystemMenu.menu();

    }
}
