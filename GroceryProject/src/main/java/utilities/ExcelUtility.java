package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import constant.Constants;

public class ExcelUtility {
	static FileInputStream f; // to enter into an external file to read a file
	static HSSFWorkbook wb; // in excel-sheet its in workbook mode to read data
	static HSSFSheet sh; // to read details form the sheet

	public static String getStringData(int a, int b, String sheet) throws IOException {
		//f = new FileInputStream(
				//"C:\\Users\\dpk21\\eclipse-workspace\\GroceryProject\\src\\test\\resources\\TestData.xls");
		//OR 
		f = new FileInputStream(
				Constants.testDatafile); // follow same for others too
		wb = new HSSFWorkbook(f);
		sh = wb.getSheet(sheet);
		HSSFRow r = sh.getRow(a); // getRow is a method used to get details from the excel sheet- ROW
		HSSFCell c = r.getCell(b); // getCell is a method used to get details from the excel sheet Row- cell
		return c.getStringCellValue(); // method to get a string value from the cell
	}

	public static String getIntegerData(int a, int b, String sheet) throws IOException {
		f = new FileInputStream(
				/*"C:\\Users\\dpk21\\eclipse-workspace\\GroceryProject\\src\\test\\resources\\TestData.xls"*/
				Constants.testDatafile);
		
		wb = new HSSFWorkbook(f);
		sh = wb.getSheet(sheet);
		HSSFRow r = sh.getRow(a);
		HSSFCell c = r.getCell(b);
		// type casting is doing
		int num = (int) c.getNumericCellValue(); // converting the value to int
		return String.valueOf(num); // (string) any data type conversion : valueOf
	}

	public static String getFloatData(int a, int b, String sheet) throws IOException {
		f = new FileInputStream(
				/*"C:\\Users\\dpk21\\eclipse-workspace\\GroceryProject\\src\\test\\resources\\TestData.xls"*/
				Constants.testDatafile);
		wb = new HSSFWorkbook(f);
		sh = wb.getSheet(sheet);
		HSSFRow r = sh.getRow(a);
		HSSFCell c = r.getCell(b);
		// type casting is doing
		Float num = (float) c.getNumericCellValue(); // converting the value to integer
		return String.valueOf(num); // (string) any data type conversion : valueOf
	}


}
