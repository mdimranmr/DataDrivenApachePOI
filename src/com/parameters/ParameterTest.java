package com.parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {

	WebDriver driver;
	
	@Test
	@Parameters({"env", "browser", "url", "username"})
	public void YahooLoginPageTest(String env, String browser, String url, String username) {
		if(browser.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "/Users/Imran/Desktop/Selenium/chromedriver");
		driver=new ChromeDriver();
		}
		driver.get("https://login.yahoo.com");
		driver.findElement(By.xpath("//input[@id='login-username']")).clear();
		driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys("test@yahoo.com");
		driver.findElement(By.xpath("//input[@id='login-signin']")).click();
	}
	
}
