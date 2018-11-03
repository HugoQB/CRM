package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	static Workbook book;
	static Sheet sheet;
	public String pathName = "CRM\\src\\main\\java\\com\\crm\\qa\\data\\practicaSeleniumData.xlsx";
	
	public void switchToFrame(String name) {
		driver.switchTo().frame(name);
	}
	
	public void switchToFrame(int n) {
		driver.switchTo().frame(n);
	}
	
	public Object[][] getTestData(String sheetName, String pathName){
		FileInputStream file = null;
		try {
			file = new FileInputStream(pathName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		sheet.forEach((x)->{
			x.forEach((z)->{ 
				if(!(z.getRowIndex()==0)) {
				data[z.getRowIndex()-1][z.getColumnIndex()] = z.getStringCellValue();
//				System.out.println(data[z.getRowIndex()-1][z.getColumnIndex()]);
				}
			}); 
		});

		return data;
	
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException{
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir = prop.getProperty("user.dir");
		FileUtils.copyFile(file, new File(currentDir + "/screenShots/"+System.currentTimeMillis() + ".png"));
	}
	
	public static void main(String [] x) {
//		TestUtil tu = new TestUtil();
//		tu.getTestData("Contacts", tu.pathName);
	}

}
