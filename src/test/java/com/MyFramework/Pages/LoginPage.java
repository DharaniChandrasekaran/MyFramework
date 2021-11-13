package com.MyFramework.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	//Test

	public LoginPage(WebDriver driver)
	{ 
		this.driver=driver;
	}
	
	@FindBy(name="username")
	WebElement uname; 
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement submit;
	
	public void LaunchWebApplication(String usname, String pword)
	{
		uname.clear();
		password.clear();
		uname.sendKeys(usname);
		password.sendKeys(pword);
		submit.click();
	}
	

}
