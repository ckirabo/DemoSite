package com.qa.clare.DemoSite;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestDemoSite {

	public static ExtentReports report;
	public static ExtentTest test;

	WebDriver driver;

	@BeforeClass
	public static void startClass() {
		report = new ExtentReports(Constant.reportLocation + Constant.nameOfReport, false);
	}

	@Before
	public void startUp() {
		System.setProperty("webdriver.chrome.driver", Constant.driverLocation);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void testToEnterDummyDataFromExcellLogsIn() throws InterruptedException {

		

		test = report.startTest("Starting Test ...");

		test.log(LogStatus.INFO, "Browser Started");

		
		driver.get(Constant.websiteURL);
		HomePage page = PageFactory.initElements(driver, HomePage.class);
		page.goToAddUser(driver);

		
		ExcelUtils.setExcelFile(Constant.pathToExcell + Constant.excellTestData, 0);
	
		
		int rows = ExcelUtils.getExcelWSheet().getPhysicalNumberOfRows();
		
	

		for (int i = 0; i < rows; i++) {
			
			String username = ExcelUtils.getCellData(i, 0);
			String password = ExcelUtils.getCellData(i, 1);

			driver.get(Constant.addUserURL);
			AddUserPage page2 = PageFactory.initElements(driver, AddUserPage.class);
			page2.logIn(username, password);

			driver.get(Constant.LoginURL);
			loginPage page3 = PageFactory.initElements(driver, loginPage.class);
			page3.logInMethod(username, password);
			
			//test

			if (page3.logInMethod(username, password).equals("**Successful Login**")) {
				test.log(LogStatus.PASS, "Verify user has logged in");
			} else {
				test.log(LogStatus.FAIL, "Verify user has logged in");
			}

			assertEquals("", "**Successful Login**",page3.logInMethod(username, password));

		}
		
		//repeats the names 3 times each....
	
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@AfterClass
	public static void endClass() {
		report.endTest(test);
		report.flush();
	}
}
