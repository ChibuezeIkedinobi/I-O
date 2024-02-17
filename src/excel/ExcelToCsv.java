package excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExcelToCsv {
    public static void main(String[] args) {
        convertExcelToCsv("query_result.xlsx", "csvConversion.csv");
    }

    public static void convertExcelToCsv(String excelFilePath, String csvFilePath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(excelFilePath));
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);
            PrintWriter printWriter = new PrintWriter(new FileWriter(csvFilePath));

            for (Row row : sheet) {
                for (Cell cell: row) {
                    printWriter.print(cell.getStringCellValue() +",");
                }
                printWriter.println();
            }
            printWriter.close();
            workbook.close();
            fileInputStream.close();
            System.out.println("Success...");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
