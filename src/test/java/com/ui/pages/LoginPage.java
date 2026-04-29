package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

public final class LoginPage extends BrowserUtility {

	Logger logger = LoggerUtility.getLogger(this.getClass());
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	private static final By EMAIL_ID_LOCATOR = By.xpath("//input[@id='email']");
	private static final By PASSWORD_LOCATOR = By.id("passwd");
	private static final By SUBMIT_BUTTON_LOCATOR = By.id("SubmitLogin");

	public MyAccountPage performLoginWith(String emailId, String password) {
		logger.info("Entering email: "+emailId+" and Password : "+password);
		enterText(EMAIL_ID_LOCATOR, emailId);
		enterText(PASSWORD_LOCATOR, password);
		clickOn(SUBMIT_BUTTON_LOCATOR);
		MyAccountPage myAccountPage = new MyAccountPage(getDriver());
		return myAccountPage;

	}

}
