package excel;

import org.apache.poi.ss.usermodel.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExcelToCsv2 {

    public static void main(String[] args) throws Exception {

        int[] rowsToRead = {2, 3, 4, 7, 9, 11, 15, 18};


        try (
                InputStream inputStream = new FileInputStream("query_result.xlsx");
             BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get("sample.csv"))
        ) {
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

            int currentRow = 1;
            for (Row row : sheet) {
                if (containsRow(currentRow, rowsToRead)) {
                    boolean firstCell = true;
                    for (Cell cell : row) {
                        if (!firstCell) bufferedWriter.write("---");

                        String text = getCellText(cell, evaluator);
                        bufferedWriter.write(text);
                        firstCell = false;
                    }
                    bufferedWriter.newLine();
                }
                currentRow++;
            }
            System.out.println("Success...");
        }
    }

    private static boolean containsRow(int row, int[] rows) {
        for (int r : rows) {
            if (row == r) {
                return true;
            }
        }
        return false;
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

