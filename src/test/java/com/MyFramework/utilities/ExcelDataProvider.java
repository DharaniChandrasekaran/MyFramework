package com.MyFramework.utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook wb;

	public ExcelDataProvider() {
		File file = new File("./TestData/Data.xlsx");
		try {

			FileInputStream fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to read the values in excel " + e.getMessage());
		}
	}

	public String getStringData(String SheetName, int row, int cell) {
		return wb.getSheet(SheetName).getRow(row).getCell(cell).getStringCellValue();
	}

	public String getStringData(int SheetIndex, int row, int cell) {
		return wb.getSheetAt(SheetIndex).getRow(row).getCell(cell).getStringCellValue();
	}

	public double getNumericData(String SheetName, int row, int cell) {
		return wb.getSheet(SheetName).getRow(row).getCell(cell).getNumericCellValue();
	}
}
