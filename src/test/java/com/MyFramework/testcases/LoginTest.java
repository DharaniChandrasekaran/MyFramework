package com.MyFramework.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.MyFramework.utilities.BrowserFactory;

public class LoginTest {

	WebDriver driver;
    @Test
	public void startWebApplication() {
		
		driver = BrowserFactory.startWebApp(driver, "Chrome", "https://classic.freecrm.com/index.html?e=1");
	    System.out.println(driver.getTitle());
	    BrowserFactory.closeBrowser(driver);
	    
    }
}
