package com.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Base.TestBase;
import com.google.common.io.Files;

public class TestUtil extends TestBase {

	public static final long implicit_Wait_Time = 13;
	public static final long page_load_Wait_Time = 10;
	
	public static String path = "/Users/miraz/eclipse-workspace/OnlineShopping/Datas/RegData.xlsx";
	static Workbook book;
	static Sheet sheet;
	public static FileInputStream file;
	

	public TestUtil() throws IOException {
		super();

	}
	public static Object[][] getTestData(String sheetName) {		
		
	try {
		file  = new FileInputStream(path);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}try {
		book = WorkbookFactory.create(file);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	sheet = book.getSheet(sheetName);
	Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(1).getLastCellNum()];
	System.out.println("Total found "+sheet.getLastRowNum()+ " ROW's and "+sheet.getRow(0).getLastCellNum()+" COLUMN's in this table....\n");
	for(int i =0; i<sheet.getLastRowNum(); i++) {
		for(int j = 0; j<sheet.getRow(0).getLastCellNum(); j++) {
			data[i][j]= sheet.getRow(i+1).getCell(j).toString(); // i+1 cell--0
			System.out.print(data[i][j]+" \t");
			
		}
		System.out.println("\n");
	}
	return data;
	}

	
	public static void takeScreenshoot() throws IOException{
		// Convert webdriver to TakeScreenshot
		File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// Copy the file to a location and use try catch block to handle exception
		Files.copy(screenShot, new File("/Users/miraz/eclipse-workspace/OnlineShopping/Snapshoot/Photos"+System.currentTimeMillis()+".jpeg"));
	}
	public static void expliciteWait(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, implicit_Wait_Time);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locator)));
		}
	public static void selectFunctions(WebElement locator) {
		Select select = new Select(locator);
		//select.selectByIndex(click);
		
	}

}
