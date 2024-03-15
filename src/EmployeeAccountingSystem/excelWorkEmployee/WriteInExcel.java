package EmployeeAccountingSystem.excelWorkEmployee;

import EmployeeAccountingSystem.EmployeeEntities.Employee;
import generalMenu.EmployeeMenu;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class WriteInExcel {
    @SuppressWarnings("deprecation")
    public static void writeIntoExcel(String file){
        Workbook book = new HSSFWorkbook();
        Sheet sheet = book.createSheet("Employee");

        Row row = sheet.createRow(0);

        Cell name = row.createCell(0);
        name.setCellValue("sanan");

        Cell birthdate = row.createCell(1);

        DataFormat format = book.createDataFormat();
        CellStyle dateStyle = book.createCellStyle();
        dateStyle.setDataFormat(format.getFormat("dd.mm.yyyy"));
        birthdate.setCellStyle(dateStyle);

        birthdate.setCellValue(new Date(109, 12, 15));

        sheet.autoSizeColumn(1);

        try {
            book.write(new FileOutputStream(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            book.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void write(String file, List<Employee> list) throws FileNotFoundException {

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
        headerCell.setCellValue("dateOfBirth");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(5);
        headerCell.setCellValue("gender");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(6);
        headerCell.setCellValue("phone");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(7);
        headerCell.setCellValue("jobTitle");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(8);
        headerCell.setCellValue("department");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(9);
        headerCell.setCellValue("ChiefSurname");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(10);
        headerCell.setCellValue("employmentDate");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(11);
        headerCell.setCellValue("salary");
        headerCell.setCellStyle(headerStyle);

        int i = list.size()-1;
        for (int j = 0; j < list.size(); j++) {
            CellStyle style = workbook.createCellStyle();
            style.setWrapText(true);

            Row row = sheet.createRow(j+1);
            Cell cell = row.createCell(0);
            cell.setCellValue(list.get(i).getId());
            cell.setCellStyle(style);

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
        EmployeeMenu.menu();

    }
}
