package com.datadriven.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.excel.utility.Xls_Reader;

public class ParametrizeTest {

	public static void main(String[] args){
		
		System.setProperty("webdriver.chrome.driver", "/Users/Imran/Desktop/Selenium/chromedriver");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.freecrm.com/register/");
		
		Xls_Reader reader=new Xls_Reader("/Users/Imran/Documents/workspace/DataDrivenApachePOI/src/com/testdata/FreeCrm_TestData.xlsx");
		int rowCount = reader.getRowCount("Register");
		
		reader.addColumn("Register", "Status");
			
		for(int rowNum=2; rowNum<=rowCount; rowNum++) {
			System.out.println("--------------------");
			String FirstName  = reader.getCellData("Register", "firstname", rowNum);
			System.out.println(FirstName);
			
			String LastName = reader.getCellData("Register", "lastname", rowNum);
			System.out.println(LastName);
			
			String EmailAddress = reader.getCellData("Register", "emailaddress", rowNum);
			System.out.println(EmailAddress);
			
			String Username = reader.getCellData("Register", "username", rowNum);
			System.out.println(Username);
			
			String Password = reader.getCellData("Register", "password", rowNum);
			System.out.println(Password);
			
			
			//***************Enter the data***************
			
			Select select=new Select(driver.findElement(By.xpath("//select[@id='payment_plan_id']")));
			select.selectByVisibleText("Free Edition");
			
			driver.findElement(By.xpath("//input[@name='first_name']")).clear();
			driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(FirstName);
			
			driver.findElement(By.xpath("//input[@name='surname']")).clear();
			driver.findElement(By.xpath("//input[@name='surname']")).sendKeys(LastName);
			
			driver.findElement(By.xpath("//input[@name='email']")).clear();
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys(EmailAddress);
			
			driver.findElement(By.xpath("//input[@name='email_confirm']")).clear();
			driver.findElement(By.xpath("//input[@name='email_confirm']")).sendKeys(EmailAddress);
			
			driver.findElement(By.xpath("//input[@name='username']")).clear();
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Username);
			
			driver.findElement(By.xpath("//input[@name='password']")).clear();
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Password);
			
			driver.findElement(By.xpath("//input[@name='passwordconfirm']")).clear();
			driver.findElement(By.xpath("//input[@name='passwordconfirm']")).sendKeys(Password);
		
			driver.findElement(By.xpath("//input[@type='checkbox']")).click();
			
			reader.setCellData("Register", "Status", rowNum, "Pass");
			
		}
	
		
	}
}
