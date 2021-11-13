package com.MyFramework.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	public static String Screenshot(WebDriver driver) {
		
        System.out.println("Entered screenshot func");
		String ScreenshotPath=System.getProperty("user.dir")+"/Screenshots/FreeCRM_"+getCurrentDateTime()+".png";
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		System.out.println("Screenshot taken");
		try {
			FileHandler.copy(src, new File(ScreenshotPath));
			System.out.println("Copied to dest path");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to capture screenshot--" + e.getMessage());
		}
		
		return ScreenshotPath;

	}
	
	public static String getCurrentDateTime() {
		DateFormat customformat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date date=new Date();
		return customformat.format(date);
		
	}
}
