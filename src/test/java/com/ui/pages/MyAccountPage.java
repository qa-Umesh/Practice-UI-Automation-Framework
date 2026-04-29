package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class MyAccountPage extends BrowserUtility {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	private static final By HOME_TEXT_LOCATOR = By.xpath("//a[@title='View my customer account']//span");

	public String getHomeText() {
		return getVisibleText(HOME_TEXT_LOCATOR);
	}

}
