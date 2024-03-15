package authorization.workWithExcel;

import EmployeeAccountingSystem.EmployeeEntities.Employee;
import FinanceAccountingSystem.financeEntities.FinanceAccount;
import adminPanel.AdminMenu;
import authorization.Entities.User;
import generalMenu.EmployeeMenu;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class AddInExcelUsers {
    public static void add(String file, List<User> users) {
        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("Persons");
        sheet.setColumnWidth(0, 6000);
        sheet.setColumnWidth(1, 6000);
        sheet.setColumnWidth(2, 6000);
        sheet.setColumnWidth(3, 6000);

        Row header = sheet.createRow(0);

        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
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
        headerCell.setCellValue("login");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(2);
        headerCell.setCellValue("password");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(3);
        headerCell.setCellValue("email");
        headerCell.setCellStyle(headerStyle);

        int i = users.size()-1;
        for (int j = 0; j < users.size(); j++) {
            CellStyle style = workbook.createCellStyle();
            style.setWrapText(true);

            Row row = sheet.createRow(j + 1);
            Cell cell = row.createCell(0);
            cell.setCellValue(users.get(i).getId());
            cell.setCellStyle(style);

            cell = row.createCell(1);
            cell.setCellValue(users.get(i).getLogin());
            cell.setCellStyle(style);

            cell = row.createCell(2);
            cell.setCellValue(users.get(i).getPassword());
            cell.setCellStyle(style);

            cell = row.createCell(3);
            cell.setCellValue(users.get(i).getEmail());
            cell.setCellStyle(style);
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

        try {
            AdminMenu.menu();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
