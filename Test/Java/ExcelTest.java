import EmployeeAccountingSystem.ExelHelper.ExcelHelp;
import bookStore.bookGetsOrPrint.PrintAllBooks;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class ExcelTest {
    private ExcelHelp excelHelp;
    private static String FILE_NAME = "temp.xlsx";
    private String fileLocation;

    @Before
    public void generateExcelFile() throws IOException {
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        fileLocation = path.substring(0, path.length() - 1) + FILE_NAME;

        excelHelp = new ExcelHelp();
        excelHelp.writeExcel();
    }

    @Test
    public void whenParsingPOIExcelFile_thenCorrect() throws IOException {
        Map<Integer, List<String>> data
                = excelHelp.readExcel(fileLocation);

        assertEquals("Name", data.get(0).get(0));
        assertEquals("Age", data.get(0).get(1));

        assertEquals("Nizami Alekperov", data.get(1).get(0));
        assertEquals("18", data.get(1).get(1));
    }
}

