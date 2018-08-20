package com.datadriven.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.utilities.TestUtil;

public class FreecrmRegistrationTest {

	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/Imran/Desktop/Selenium/chromedriver");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.freecrm.com/register/");
	}
	
	
	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testdata = TestUtil.getDataFromExcel();
		return testdata.iterator();
		
	}
	
	
	@Test(dataProvider="getTestData")
	public void FreecrmRegistration(String FirstName, String LastName, String EmailAddress, String Username, String Password) {
		
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
		
	}
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
