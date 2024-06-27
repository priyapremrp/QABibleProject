package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	
	
	static FileInputStream f;
	static XSSFWorkbook w;
	static XSSFSheet sh;
	
	public static String getStringData(int a, int b) throws IOException
	{
		
		f=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\Book2.xlsx");
		w=new XSSFWorkbook(f);
		sh=w.getSheet("Sheet1");
		Row r=sh.getRow(a); //interface
		Cell c=r.getCell(b); //interface
		return c.getStringCellValue();
	}
	
}
