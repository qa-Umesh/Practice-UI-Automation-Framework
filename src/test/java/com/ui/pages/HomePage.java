package com.ui.pages;

import static com.ui.constants.Env.DEV;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.constants.Browser;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;
import com.utility.PropertyReaderUtility;

public final class HomePage extends BrowserUtility {

	Logger logger = LoggerUtility.getLogger(this.getClass());
	private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(),'Sign in')]");

	public HomePage(WebDriver browser) {
		super(browser);
		// goToWebsite(readConfigData(QA).getUrl());
		goToWebsite(PropertyReaderUtility.readProperty(DEV, "URL"));

	}

	public HomePage(Browser browser, Boolean isHeadless) {
		super(browser, isHeadless);
		// goToWebsite(readConfigData(QA).getUrl());
		goToWebsite(PropertyReaderUtility.readProperty(DEV, "URL"));

	}
	
	public void quite() {
		getDriver().quit();
	}

	public LoginPage goToLoginPage() {
		logger.info("Trying to perform Click action in sign in page");
		clickOn(SIGN_IN_LINK_LOCATOR); // click the sign in
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}

}
