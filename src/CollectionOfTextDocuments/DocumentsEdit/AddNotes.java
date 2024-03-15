package CollectionOfTextDocuments.DocumentsEdit;

import CollectionOfTextDocuments.workWithFiles.AddInFIle;
import EmployeeAccountingSystem.EmployeeEntities.Employee;
import EmployeeAccountingSystem.EmployeeGetsOrPrint.GetAllEmployee;
import constants.ConstOther;
import generalMenu.CollectionOfTextDocumentsMenu;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddNotes {
    public static void add(){
        System.out.println("\n\t-[ введите id работника, которому хотите добавить заметку ]-");
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
        long id = new Scanner(System.in).nextLong();
        String name = null;
        for (Employee employee : employees){
            if (employee.getId().equals(id)){
                name = employee.getName() + " " + employee.getSurname();
            }
        }
        try {
            createNote(ConstOther.FILE_PATH_EXCEL_NOTES, id, name);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createNote(String file, long id, String name) throws FileNotFoundException {
        file = file + id + "_";

        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("Notes");
        sheet.setColumnWidth(0, 7000);
        for (int i = 1; i < 100; i++) {
            sheet.setColumnWidth(i, 5000);
        }

        Row header = sheet.createRow(0);


        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName("Arial");
        font.setFontHeightInPoints((short) 16);
        font.setBold(true);
        headerStyle.setFont(font);

        Cell headerCell = header.createCell(0);
        headerCell.setCellValue(name);
        headerCell.setCellStyle(headerStyle);
        List<String> list = new ArrayList<>();
        list.add(name);

        System.out.println("\n\t-[ сколько заметок вы хотите добавить? 1 пользователю можно добавить максимум 3 заметки ]-\n");
        int num = new Scanner(System.in).nextInt();
        switch (num) {
            case 1 -> {
                System.out.println("\n\t-[ введите заметку ]-");
                String first = new Scanner(System.in).nextLine();
                String[] text = (first).split(" ");
                CellStyle style = workbook.createCellStyle();
                style.setWrapText(true);
                Row row = sheet.createRow(1);
                for (int j = 0; j < text.length; j++) {

                    Cell cell = row.createCell(j+1);
                    cell.setCellValue(text[j]);
                    cell.setCellStyle(style);
                }
                Cell firstCell = row.createCell(0);
                firstCell.setCellValue("1 заметка");
                firstCell.setCellStyle(headerStyle);
                list.add(first);
            }
            case 2 -> {

                System.out.println("\n\t-[ введите первую заметку ]-");
                String first = new Scanner(System.in).nextLine();
                String[] text = (first).split(" ");
                CellStyle style = workbook.createCellStyle();
                style.setWrapText(true);
                Row row = sheet.createRow(1);
                for (int j = 0; j < text.length; j++) {

                    Cell cell = row.createCell(j+1);
                    cell.setCellValue(text[j]);
                    cell.setCellStyle(style);
                }
                Cell firstCell = row.createCell(0);
                firstCell.setCellValue("1 заметка");
                firstCell.setCellStyle(headerStyle);

                System.out.println("\n\t-[ введите вторую заметку ]-");
                String second = new Scanner(System.in).nextLine();
                String[] text1 = (second).split(" ");
                row = sheet.createRow(2);
                for (int j = 0; j < text1.length; j++) {

                    Cell cell = row.createCell(j+1);
                    cell.setCellValue(text1[j]);
                    cell.setCellStyle(style);
                }

                firstCell = row.createCell(0);
                firstCell.setCellValue("2 заметка");
                firstCell.setCellStyle(headerStyle);
                list.add(first);
                list.add(second);
            }
            case 3 -> {

                System.out.println("\n\t-[ введите первую заметку ]-");
                String first = new Scanner(System.in).nextLine();
                String[] text = (first).split(" ");
                CellStyle style = workbook.createCellStyle();
                style.setWrapText(true);
                Row row = sheet.createRow(1);
                for (int j = 0; j < text.length; j++) {

                    Cell cell = row.createCell(j+1);
                    cell.setCellValue(text[j]);
                    cell.setCellStyle(style);
                }
                Cell firstCell = row.createCell(0);
                firstCell.setCellValue("1 заметка");
                firstCell.setCellStyle(headerStyle);

                System.out.println("\n\t-[ введите вторую заметку ]-");
                String second = new Scanner(System.in).nextLine();
                String[] text1 = (second).split(" ");
                row = sheet.createRow(2);
                for (int j = 0; j < text1.length; j++) {

                    Cell cell = row.createCell(j+1);
                    cell.setCellValue(text1[j]);
                    cell.setCellStyle(style);
                }
                firstCell = row.createCell(0);
                firstCell.setCellValue("2 заметка");
                firstCell.setCellStyle(headerStyle);

                System.out.println("\n\t-[ введите третью заметку ]-");
                String third = new Scanner(System.in).nextLine();
                String[] text2 = (third).split(" ");
                row = sheet.createRow(3);
                for (int j = 0; j < text2.length; j++) {

                    Cell cell = row.createCell(j+1);
                    cell.setCellValue(text2[j]);
                    cell.setCellStyle(style);
                }
                firstCell = row.createCell(0);
                firstCell.setCellValue("3 заметка");
                firstCell.setCellStyle(headerStyle);
                list.add(first);
                list.add(second);
                list.add(third);
            }
            default -> createNote(file, id, name);
        }
        String text = "";
        for(String a : list){
            assert false;
            text += (a) + ("\n");
        }
        AddInFIle.write(text, id);

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
        CollectionOfTextDocumentsMenu.menu();
        }
    }
