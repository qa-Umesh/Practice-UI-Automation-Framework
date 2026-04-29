package com.ui.test;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.ui.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LamdaTestUtility;

public class BaseTest {

	protected HomePage homePage;

	boolean isHeadless;
	private boolean isLamdaTest;

	@Parameters({ "browser", "isLamdaTest", "isHeadless" })
	@BeforeMethod
	public void setup(String browser, boolean isLamdaTest, boolean isHeadless, ITestResult result) {

		this.isLamdaTest = isLamdaTest;
		WebDriver lamdaDriver;
		if (isLamdaTest) {
			lamdaDriver = LamdaTestUtility.createLamdaTestSession(browser, result.getMethod().getMethodName());
			homePage = new HomePage(lamdaDriver);

		} else {
			homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadless);

		}

	}

	@AfterMethod
	public void quite() {
		if (isLamdaTest) {
			LamdaTestUtility.quiteSession();
		} else {
			homePage.quite();
		}
	}

	public BrowserUtility getInstance() {

		return homePage;
	}

}
