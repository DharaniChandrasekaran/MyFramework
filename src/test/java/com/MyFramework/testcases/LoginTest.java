package com.MyFramework.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.MyFramework.Pages.LoginPage;
import com.MyFramework.utilities.BaseClass;


public class LoginTest extends BaseClass {

	@Test
	public void startWebApplication() {
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		logger=report.createTest("Login");
		logger.info("Login process started");
		login.LaunchWebApplication(excel.getStringData("LoginPage", 0, 0), excel.getStringData("LoginPage", 0, 1));
		System.out.println("Application logged in ");
		logger.pass("Successfully logged in!");
	}

}
