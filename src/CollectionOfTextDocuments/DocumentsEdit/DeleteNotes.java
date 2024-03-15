package CollectionOfTextDocuments.DocumentsEdit;

import CollectionOfTextDocuments.getAllNotes.GetsNotes;
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

public class DeleteNotes {
    public static void edit(){
        System.out.println("\n\t-[ чью заметку вы хотите удалить? ]-");
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

        System.out.println("\n\t-[ какую заметку вы хотите удалить? ]-");
        int numberNote = new Scanner(System.in).nextInt();

        String name = null;
        for (Employee employee : employees){
            if (employee.getId().equals(id)){
                name = employee.getName() + " " + employee.getSurname();
            }
        }


        String newNote = "";

        editNote(ConstOther.FILE_PATH_EXCEL_NOTES + id + "-", id, numberNote, name, newNote);

        CollectionOfTextDocumentsMenu.menu();

    }

    public static void editNote(String file, long id, int numberNote, String name, String newNote){

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

        List<String> newList = new ArrayList<>();
        List<List<String>> list = GetsNotes.getAllNotes();
        int lenght = 0;
        for (List<String> a : list){
            if (a.get(0).equals(name)){
                lenght = a.size();
            }
        }
        boolean flag = true;
        switch (lenght-1){
            case 1 -> {
                String first = null;
                if (numberNote == 1) {
                    first = newNote;
                    flag = false;
                }else {
                    for (List<String> a : list){
                        if (a.get(0).equals(name)) {
                            first = a.get(1);
                        }
                    }
                }
                if (flag) {
                    String[] text = (first).split(" ");
                    CellStyle style = workbook.createCellStyle();
                    style.setWrapText(true);
                    Row row = sheet.createRow(1);
                    for (int j = 0; j < text.length; j++) {

                        Cell cell = row.createCell(j + 1);
                        cell.setCellValue(text[j]);
                        cell.setCellStyle(style);
                    }

                    Cell firstCell = row.createCell(0);
                    firstCell.setCellValue("1 заметка");
                    firstCell.setCellStyle(headerStyle);
                    newList.add(first);
                }
            }
            case 2 -> {
                flag = true;
                String first = null;
                if (numberNote == 1) {
                    flag = false;
                    first = newNote;
                }else {
                    for (List<String> a : list){
                        if (a.get(0).equals(name)) {
                            first = a.get(1);
                        }
                    }
                }
                String[] text = (first).split(" ");
                CellStyle style = workbook.createCellStyle();
                style.setWrapText(true);
                if (flag){
                    Row row = sheet.createRow(1);
                    for (int j = 0; j < text.length; j++) {

                        Cell cell = row.createCell(j + 1);
                        cell.setCellValue(text[j]);
                        cell.setCellStyle(style);
                    }
                    Cell firstCell = row.createCell(0);
                    firstCell.setCellValue("1 заметка");
                    firstCell.setCellStyle(headerStyle);
                }

                String second = null;
                flag = true;
                if (numberNote == 2) {
                    flag = false;
                    second = newNote;
                }else {
                    for (List<String> a : list){
                        if (a.get(0).equals(name)) {
                            second = a.get(2);
                        }
                    }
                }
                String[] text1 = (second).split(" ");
                if (flag) {
                    Row row = sheet.createRow(2);
                    for (int j = 0; j < text1.length; j++) {

                        Cell cell = row.createCell(j + 1);
                        cell.setCellValue(text1[j]);
                        cell.setCellStyle(style);
                    }
                    Cell firstCell = row.createCell(0);
                    firstCell.setCellValue("2 заметка");
                    firstCell.setCellStyle(headerStyle);
                    newList.add(first);
                    newList.add(second);
                }
            }
            case 3 -> {
                flag = true;
                String first = null;
                if (numberNote == 1) {
                    flag = false;
                    first = newNote;
                }else {
                    for (List<String> a : list){
                        if (a.get(0).equals(name)) {
                            first = a.get(1);
                        }
                    }
                }
                String[] text = (first).split(" ");
                CellStyle style = workbook.createCellStyle();
                style.setWrapText(true);
                if (flag) {
                    Row row = sheet.createRow(1);
                    for (int j = 0; j < text.length; j++) {

                        Cell cell = row.createCell(j + 1);
                        cell.setCellValue(text[j]);
                        cell.setCellStyle(style);
                    }
                    Cell firstCell = row.createCell(0);
                    firstCell.setCellValue("1 заметка");
                    firstCell.setCellStyle(headerStyle);
                }
                String second = null;
                flag = true;
                if (numberNote == 2) {
                    flag = false;
                    second = newNote;
                }else {
                    for (List<String> a : list){
                        if (a.get(0).equals(name)){
                            second = a.get(2);
                        }
                    }
                }
                String[] text1 = (second).split(" ");
                if (flag) {
                    Row row = sheet.createRow(2);
                    for (int j = 0; j < text1.length; j++) {

                        Cell cell = row.createCell(j + 1);
                        cell.setCellValue(text1[j]);
                        cell.setCellStyle(style);
                    }
                    Cell firstCell = row.createCell(0);
                    firstCell.setCellValue("2 заметка");
                    firstCell.setCellStyle(headerStyle);
                }
                String third = null;
                flag = true;
                if (numberNote == 3) {
                    flag = false;
                    third = newNote;
                }else {
                    for (List<String> a : list){
                        if (a.get(0).equals(name)) {
                            third = a.get(3);
                        }
                    }
                }
                String[] text2 = (third).split(" ");
                if (flag) {
                    Row row = sheet.createRow(3);
                    for (int j = 0; j < text2.length; j++) {

                        Cell cell = row.createCell(j + 1);
                        cell.setCellValue(text2[j]);
                        cell.setCellStyle(style);
                    }
                    Cell firstCell = row.createCell(0);
                    firstCell.setCellValue("3 заметка");
                    firstCell.setCellStyle(headerStyle);
                    newList.add(first);
                    newList.add(second);
                    newList.add(third);
                }
            }
        }

        String text = name + "\n";
        for(String a : newList){
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
    }
}
