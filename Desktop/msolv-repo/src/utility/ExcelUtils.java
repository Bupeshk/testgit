package utility;
 
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

 
    public class ExcelUtils {
 
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
 
    	    public static String getCellData(int RowNum, int ColNum) throws Exception{
 
       			try{
 
          			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
 
          			String CellData = Cell.getStringCellValue();
 
          			return CellData;
 
          			}catch (Exception e){
 
						return"";
 
          			}
 
		    }
 
    		//This method is to write in the Excel cell, Row num and Col num are the parameters
 
    		@SuppressWarnings("static-access")
			public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception	{
 
       			try{
       				Result = Result.trim();
          			Row  = ExcelWSheet.getRow(RowNum);
 
					Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
 
					if (Cell == null) {
 
						Cell = Row.createCell(ColNum);
 
						Cell.setCellValue(Result);
 
						} else {
 
							Cell.setCellValue(Result);
 
						}
					
					
					
 
          // Constant variables Test Data path and Test Data file name
 
          				FileOutputStream fileOut = new FileOutputStream(GUI_Constant.Path_TestData + GUI_Constant.File_TestData);
 
          				ExcelWBook.write(fileOut);
 
          				fileOut.flush();
 
 						fileOut.close();
 
						}catch(Exception e){
 
							throw (e);
 
					}
 
				}
 
    		
    		public static int getRowContains(String sTestCaseName, int colNum) throws Exception{
    			int i;
    		    try {
    			    int rowCount = ExcelWSheet.getLastRowNum();
    		        for ( i=0 ; i<rowCount; i++){
    			        if  (ExcelUtils.getCellData(i,colNum).equalsIgnoreCase(sTestCaseName)){
    			            break;
    			           }
    			        }
    		        return i;
    		    }catch (Exception e){
    			    Log.error("Class ExcelUtil | Method getRowContains | Exception desc : " + e.getMessage());
    		        throw(e);
    			    }
    		    }
    		
    		public static int getRowCount() throws Exception{
    			int rowCount;
    		    try {
    			    rowCount = ExcelWSheet.getLastRowNum();
    		        
    		    }catch (Exception e){
    			    Log.error("Class ExcelUtil | Method getRowCount | Exception desc : " + e.getMessage());
    		        throw(e);
    			    }
				
				return rowCount;
    		    }
    		
    		public static int getRowUsed() throws Exception {
    			 
        		try{
 
        			int RowCount = ExcelWSheet.getLastRowNum();
 
        			Log.info("Total number of Row used return as &lt; " + RowCount + " &gt;.");		
 
        			return RowCount;
 
        		}catch (Exception e){
 
        			Log.error("Class ExcelUtil | Method getRowUsed | Exception desc : "+e.getMessage());
 
        			System.out.println(e.getMessage());
 
        			throw (e);
 
        		}
 
        	}
    			
    		public static String getExcelData(String columnname, String rowname) {
    			ArrayList<String> testcasenamedata = new ArrayList<String>();
    			ArrayList<String> colnamedata = new ArrayList<String>();
    			int writtenrowno = ExcelWSheet.getPhysicalNumberOfRows();
    			boolean colFound = false;
    			boolean rowFound = false;	
    			String CellData = "";
    			try{
    				Row = ExcelWSheet.getRow(0);
    				int writtencolno = Row.getLastCellNum();
    				for (int i = 0; i < writtenrowno; i++) {
    					Row = ExcelWSheet.getRow(i);
    					Cell = Row.getCell(0);
    					if (Cell != null) {
    						testcasenamedata.add(Cell.getStringCellValue());
    						if (rowname.equalsIgnoreCase(testcasenamedata.get(i))) {
    							reqcellrowno = i;
    							rowFound = true;
    							break;
    						}
    					}
    				}
    				if (rowFound) {
    					for (int j = 0; j < writtencolno; j++) {
    						Row = ExcelWSheet.getRow(0);
    						Cell = Row.getCell(j);
    						if (Cell != null) {
    							colnamedata.add(Cell.getStringCellValue());
    							if (columnname.equalsIgnoreCase(colnamedata.get(j))) {
    								reqcellcolno = j;
    								colFound = true;
    								break;
    							}
    						}
    					}
    				}
    				if (colFound) {
    					Cell = ExcelWSheet.getRow(reqcellrowno).getCell(reqcellcolno);
    					if (Cell != null){
	    					if(Cell.getCellType() == org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC){
	    						if (DateUtil.isCellDateFormatted(Cell)){
	    							DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	    							CellData = df.format(Cell.getDateCellValue());
	    						}
	    						else{
	    							Cell.setCellType(org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING);
	    							CellData = Cell.getStringCellValue();
	    						}
	    					}
	    					else{
	    						Cell.setCellType(org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING);
	    						CellData = Cell.getStringCellValue();
	    					}
    					}
    				}
    				return CellData;
    			}
    			catch (Exception e) {
    				e.printStackTrace();
    				System.out.println("Error while getting the cell data by getExcelData(Str1,Str2) for column : "+columnname+" and row : "+rowname+" Exception : " + e.getMessage());
    				return CellData;
    			}		
    		}     		
    		

    		public static void setExcelData(String ExcelPath,String columnname,String rowname,String cellValue) {
    		try{
    			cellValue = cellValue.trim();
    			ArrayList<String> testcasenamedata = new ArrayList<String>();
    			ArrayList<String> colnamedata = new ArrayList<String>();
    			
    			int writtenrowno= ExcelWSheet.getPhysicalNumberOfRows();
    			Row =  ExcelWSheet.getRow(0);
    			int writtencolno= Row.getLastCellNum();
    			//System.out.println(writtencolno);
    			for(int i=0;i<writtenrowno;i++)
    			{
    				Row =  ExcelWSheet.getRow(i);
    				Cell = Row.getCell(0);
    				testcasenamedata.add(Cell.getStringCellValue());
    				if(rowname.equalsIgnoreCase(testcasenamedata.get(i)))
    				{
    					reqcellrowno=i;
    					break;
    				}
    			    //System.out.println(testcasenamedata.get(i));
    				
    			}
    			for(int j=0;j<writtencolno;j++)
    			{
    				Row =  ExcelWSheet.getRow(0);
    				Cell= Row.getCell(j);
    				colnamedata.add(Cell.getStringCellValue());
    				if(columnname.equalsIgnoreCase(colnamedata.get(j)))
    				{
    					reqcellcolno=j;
    					break;
    				}
    				//System.out.println(colnamedata.get(j));
    			}
    			Cell = ExcelWSheet.getRow(reqcellrowno).getCell(reqcellcolno);
    			if (Cell == null) {
    				Cell = ExcelWSheet.getRow(reqcellrowno).createCell(reqcellcolno);
    				Cell.setCellType(org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING);
    				Cell.setCellValue("");
    				Cell.setCellValue(cellValue);
    			} 
    			else {
    				Cell.setCellType(org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING);
    				Cell.setCellValue("");
    				Cell.setCellValue(cellValue);
    			}
    			FileOutputStream fileOut = new FileOutputStream(ExcelPath);
    			ExcelWBook.write(fileOut);
    			fileOut.close();
    		}
    		catch(Exception e){
    			System.out.println("Error while setting the data "+e.getMessage());
    		}
    		
    		}
    		    
    		 } 
    		
    		

