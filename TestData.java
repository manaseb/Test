package booking;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestData {
	public static FileInputStream fis;
	public FileOutputStream fileOut;
	private static XSSFWorkbook workbook;
	protected XSSFSheet sheet;
	private XSSFRow row;
	private XSSFCell cell;
	String path;
	
	public TestData() throws IOException {
		
		path = System.getProperty("user.dir")+"\\TestData\\details.xlsx";
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet= workbook.getSheetAt(0);
	}
}
		
