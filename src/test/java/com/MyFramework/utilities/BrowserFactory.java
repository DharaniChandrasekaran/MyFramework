package com.MyFramework.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {

	public static WebDriver startWebApp(WebDriver driver, String BrowserName, String WebAppURL) {

		if (BrowserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
			driver = new ChromeDriver();

		} else {
			System.out.println("Sorry! We do not Support this browser");
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(WebAppURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void closeBrowser(WebDriver driver)
	{
		driver.quit();
	}

}
