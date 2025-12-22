package utils;

import java.io.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReadWriteTest {

    public static void main(String[] args) throws IOException {

        ExcelReadWriteTest obj = new ExcelReadWriteTest();
        obj.writeExcel();
        //obj.readExcel();


//        XSSFWorkbook wb=new XSSFWorkbook(new FileInputStream(new File("Students.xlsx")));
//        // one line data read
//        String data= wb.getSheetAt(0).getRow(1).getCell(1).getStringCellValue();
//        System.out.println("Scenario Name : " + data);

    }

    public void readExcel() {

        try (FileInputStream file = new FileInputStream("Students.xlsx")) {
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            int rowCount = sheet.getPhysicalNumberOfRows();

            for (int i=1 ; i< rowCount; i++) {
                Row row = sheet.getRow(i);
                for(Cell cell : row){
                    if (cell != null) {
                        String testData = cell.getStringCellValue();
                        System.out.print(" " + testData);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeExcel() {
        try {
            File file = new File("StudentsOne.xlsx");

            // Create a new workbook and sheet
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Results");

            // Create a header row
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("TestCaseID");
            headerRow.createCell(1).setCellValue("Result");

            // Add test results
            Row row1 = sheet.createRow(1);
            row1.createCell(0).setCellValue("TC001");
            row1.createCell(1).setCellValue("Pass");

            Row row2 = sheet.createRow(2);
            row2.createCell(0).setCellValue("TC002");
            row2.createCell(1).setCellValue("Fail");

            // Write data to the file
            FileOutputStream fos = new FileOutputStream(file);
            workbook.write(fos);

            fos.close();

            System.out.println("Data written successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
