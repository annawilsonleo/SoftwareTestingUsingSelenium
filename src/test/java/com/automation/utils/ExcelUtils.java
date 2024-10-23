package com.automation.utils;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {
    XSSFWorkbook workbook;
    XSSFSheet sheet;

    public ExcelUtils(String fileName, String sheetName){
        try{
            workbook = new XSSFWorkbook("src/test/resources/data/Credentials.xlsx");
            sheet = workbook.getSheet("ValidData");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getTotalNumOfRow(){
        return sheet.getLastRowNum();
    }

    public int getTotalNumOfCol(){
        return sheet.getRow(0).getLastCellNum();
    }

    public List<List<String>> getData() throws IOException {
        List<List<String>> tableData = new ArrayList<>();
        for (int i = 1; i <= getTotalNumOfRow(); i++) {
            XSSFRow row = sheet.getRow(i);
            List<String> rowData = new ArrayList<>();
            for (int j = 0; j < row.getLastCellNum(); j++) {
                rowData.add(row.getCell(j).getStringCellValue());
            }
            tableData.add(rowData);
    }
    return tableData;
    }
}