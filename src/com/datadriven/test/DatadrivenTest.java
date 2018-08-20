package com.datadriven.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.excel.utility.Xls_Reader;

public class DatadrivenTest {

	public static void main(String[] args) {
			
		Xls_Reader reader=new Xls_Reader("/Users/Imran/Documents/workspace/DataDrivenApachePOI/src/com/testdata/FreeCrm_TestData.xlsx");
		
		//***************Get data from test data excel sheet***************
		
		String FirstName = reader.getCellData("Register", "firstname", 2);
		System.out.println(FirstName);
		
		String LastName = reader.getCellData("Register", "lastname", 2);
		System.out.println(LastName);
		
		String EmailAddress = reader.getCellData("Register", "emailaddress", 2);
		System.out.println(EmailAddress);
		
		String Username = reader.getCellData("Register", "username", 2);
		System.out.println(Username);
		
		String Password = reader.getCellData("Register", "password", 2);
		System.out.println(Password);
		
		//***************Webdriver code***************
		
		System.setProperty("webdriver.chrome.driver", "/Users/Imran/Desktop/Selenium/chromedriver");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.freecrm.com/register/");
		
		Select select=new Select(driver.findElement(By.xpath("//select[@id='payment_plan_id']")));
		select.selectByVisibleText("Free Edition");
		
		driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(FirstName);
		
		driver.findElement(By.xpath("//input[@name='surname']")).sendKeys(LastName);
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(EmailAddress);
		
		driver.findElement(By.xpath("//input[@name='email_confirm']")).sendKeys(EmailAddress);
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Username);
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Password);
		
		driver.findElement(By.xpath("//input[@name='passwordconfirm']")).sendKeys(Password);
	
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		
	}

}
