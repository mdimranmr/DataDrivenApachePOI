package com.webtables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class WebTableHandling {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/Imran/Desktop/Selenium/chromedriver");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		String beforeXpath_Company = "//*[@id='customers']/tbody/tr[";
		String afterXpath_Company = "]/td[1]";
		
		String beforeXpath_Contact = "//*[@id='customers']/tbody/tr[";
		String afterXpath_Contact = "]/td[2]";		
		
		List<WebElement> rows =  driver.findElements(By.xpath("//table[@id='customers']//tr"));
		System.out.println("Total number of rows are " + (rows.size()-1));
		int rowCount=rows.size();		
		
		Xls_Reader reader=new Xls_Reader("/Users/Imran/Documents/workspace/DataDrivenApachePOI/src/com/testdata/FreeCrm_TestData.xlsx");
		
		if(!reader.isSheetExist("TableData")){
			reader.addSheet("TableData");
			
			reader.addColumn("TableData", "company");
			reader.addColumn("TableData", "contact");
		}
		
		
		for(int rowNum=2; rowNum<=rowCount; rowNum++) {
			String actualXpath_company=beforeXpath_Company+rowNum+afterXpath_Company;
			String companyName = driver.findElement(By.xpath(actualXpath_company)).getText();
			System.out.println(companyName);
			reader.setCellData("TableData", "company", rowNum, companyName);
			
			String actualXpath_contact = beforeXpath_Contact+rowNum+afterXpath_Contact;
			String contactName = driver.findElement(By.xpath(actualXpath_contact)).getText();
			System.out.println(contactName);
			reader.setCellData("TableData", "contact", rowNum, contactName);
			
			System.out.println("-----------------");
		}
		
	}

}
