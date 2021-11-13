package com.MyFramework.utilities;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void setUpSuite() {
		Reporter.log("Setup is getting ready!");
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(
				new File(System.getProperty("user.dir") + "/Reports/FreeCRM_" + Helper.getCurrentDateTime() + ".html"));
		report=new ExtentReports();
		report.attachReporter(reporter);
		Reporter.log("Setup done");
	}

	@BeforeClass
	public void setUp() {
		Reporter.log("Application getting ready");
		driver = BrowserFactory.startWebApp(driver, config.getBrowser(), config.getURL());
		Reporter.log("Application up and running");

	}

	@AfterClass
	public void quit() {
		driver.quit();
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			try {
				logger.fail("Test failed due to some issue",
						MediaEntityBuilder.createScreenCaptureFromPath(Helper.Screenshot(driver)).build());
				System.out.println("Screenshot Captured!");

			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(" Unable to attach screenshot to report>>" + e.getMessage());
				logger.fail(e);
			}
		}

		else if (result.getStatus() == ITestResult.SUCCESS) {
			try {
				logger.pass("TestCase Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.Screenshot(driver)).build());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(" Unable to attach screenshot to report>>" + e.getMessage());
				logger.fail(e);
			}

		}
		report.flush();
	}
}
