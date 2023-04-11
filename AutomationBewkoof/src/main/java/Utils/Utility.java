package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
  


public class Utility {
	WebDriver driver;
	
	public static String getExceldata(String sheete, int rowe, int celle) throws IOException {
		
		
		String path = "src\\main\\resources\\testData\\Book2.xlsx";
		FileInputStream file = new FileInputStream(path);
		Workbook book = WorkbookFactory.create(file);
		Sheet sheet = book.getSheet(sheete);
		Row row = sheet.getRow(rowe);
		Cell cell = row.getCell(celle);
		try {
		String data = cell.getStringCellValue();
		return data;
		}
		 
		catch (IllegalStateException e) {
			
			double d = cell.getNumericCellValue();
			String data = Double.toString(d);
			return data;
		}
		
		finally {
			System.out.println("finally block");
		}
		
	}
	

	     	public static void captureSceenshot	(WebDriver driver, String testID) throws IOException {
	     		
	     		TakesScreenshot tss = (TakesScreenshot) driver;
	      		File src = tss.getScreenshotAs(OutputType.FILE);
	      		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss");
	      		LocalDateTime date = LocalDateTime.now();  
	      		String finalformat = date.format(dtf);
	     		File dest = new File ("test-output\\failedTestScreenshot\\"+testID+"_"+finalformat+".jpg");
	     		FileHandler.copy(src, dest);
			
			
		}
			
	}

		
		
		
		


