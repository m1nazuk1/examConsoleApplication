package bookStore.excelWork;

import EmployeeAccountingSystem.EmployeeEntities.Employee;
import bookStore.bookEntities.Book;
import generalMenu.BookStoreMenu;
import generalMenu.EmployeeMenu;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class WriteBookInExcel {
    public static void write(String file, List<Book> list) throws FileNotFoundException {

        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("Books");
        sheet.setColumnWidth(0, 6000);
        sheet.setColumnWidth(1, 6000);
        sheet.setColumnWidth(2, 6000);
        sheet.setColumnWidth(3, 6000);
        sheet.setColumnWidth(4, 6000);
        sheet.setColumnWidth(5, 6000);
        sheet.setColumnWidth(6, 6000);

        Row header = sheet.createRow(0);

        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName("Arial");
        font.setFontHeightInPoints((short) 16);
        font.setBold(true);
        headerStyle.setFont(font);

        Cell headerCell = header.createCell(0);
        headerCell.setCellValue("title");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(1);
        headerCell.setCellValue("author");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(2);
        headerCell.setCellValue("publishingHouse");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(3);
        headerCell.setCellValue("numberOfPages");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(4);
        headerCell.setCellValue("genre");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(5);
        headerCell.setCellValue("the year of publishing");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(6);
        headerCell.setCellValue("price");
        headerCell.setCellStyle(headerStyle);


        int i = list.size()-1;
        for (int j = 0; j < list.size(); j++) {
            CellStyle style = workbook.createCellStyle();
            style.setWrapText(true);

            Row row = sheet.createRow(j+1);
            Cell cell = row.createCell(0);
            cell.setCellValue(list.get(i).getTitle());
            cell.setCellStyle(style);

            cell = row.createCell(1);
            cell.setCellValue(list.get(i).getAuthor());
            cell.setCellStyle(style);

            cell = row.createCell(2);
            cell.setCellValue(list.get(i).getPublishingHouse());
            cell.setCellStyle(style);

            cell = row.createCell(3);
            cell.setCellValue(list.get(i).getNumberOfPages());
            cell.setCellStyle(style);

            cell = row.createCell(4);
            cell.setCellValue(list.get(i).getGenre());
            cell.setCellStyle(style);

            cell = row.createCell(5);
            cell.setCellValue(list.get(i).getDate().toString());
            cell.setCellStyle(style);

            cell = row.createCell(6);
            cell.setCellValue((list.get(i).getPrice()));
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
        BookStoreMenu.menu();

    }
}
