package excel;

import org.apache.poi.ss.usermodel.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExcelToCsv2 {

    public static void main(String[] args) throws Exception {
        // Step 1: Convert Excel to CSV
        try (
                InputStream inputStream = new FileInputStream("query_result.xlsx");
             BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get("csvConversion1.csv"))
        ) {
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

            for (Row row : sheet) {
                boolean firstCell = true;
                for (Cell cell : row) {
                    if (!firstCell) bufferedWriter.write("---");

                    String text = getCellText(cell, evaluator);
                    bufferedWriter.write(text);
                    firstCell = false;
                }
                bufferedWriter.newLine();
            }
            System.out.println("Success...");
        }
    }

    private static String getCellText(Cell cell, FormulaEvaluator evaluator) {
        CellType cellType = CellType.forInt(evaluator.evaluateInCell(cell).getCellType());

        switch (cellType) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    // Convert to some date format if required
                    return cell.getDateCellValue().toString();
                } else {
                    // Return as a string without scientific notation
                    return Double.toString(cell.getNumericCellValue());
                }
            default:
                return "";
        }
    }
}

