package com.verizon.cao.selenium.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import jxl.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
 


public class AdminUtils {

	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	private static XSSFRow Row;
	static int reqcellrowno;

	static int reqcellcolno;
	String CellData;

	//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method

	public static void setExcelFile(String Path,String SheetName) throws Exception {

		try {

			// Open the Excel file

			FileInputStream ExcelFile = new FileInputStream(Path);

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

		} catch (Exception e){

			throw (e);

		}

	}

	//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num



	public static void excelReader(String excelFilePath,String SheetName) throws IOException{
		//excelFilePath = "Books.xlsx";
		FileInputStream ExcelFile = new FileInputStream(excelFilePath);

		// Access the required test data sheet

		ExcelWBook = new XSSFWorkbook(ExcelFile);

		ExcelWSheet = ExcelWBook.getSheet(SheetName);


		//Workbook workbook = new XSSFWorkbook(inputStream);
		//Sheet firstSheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = ExcelWSheet.iterator();

		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();

			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				if(cell.getCellType() == Cell.CELL_TYPE_STRING)
				{
					System.out.print(cell.getStringCellValue());
					System.out.println("\t");
				}
				if(cell.getCellType() == Cell.CELL_TYPE_BOOLEAN)
				{	
					//System.out.print(cell.getBooleanCellValue());
					System.out.println("\t");
				}
				if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
				System.out.print(cell.getNumericCellValue());
				System.out.println("\t");
				}
				}
				System.out.print("");
			}
			
		}
	
	

	
		
	}



















