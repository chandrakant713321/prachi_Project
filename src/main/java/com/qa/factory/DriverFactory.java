package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
WebDriver driver ;
public static ThreadLocal<WebDriver> idriver=new ThreadLocal<>();
public void initBrowser(String browser)
{
	System.out.println("browser value is:"+ browser);
	if(browser.equals("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		idriver.set(new ChromeDriver());	
		}
	else if (browser.equals("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		idriver.set(new FirefoxDriver());	
		}

	else if (browser.equals("safari"))
	{
		WebDriverManager.safaridriver().setup();
		idriver.set(new SafariDriver());	
		}
	else
	{
		System.out.println("please pass the correct browser: "+ browser);
	}
}
	public static WebDriver getDriver()
	{
		return idriver.get();
	}
	
	
 




}
