package com.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.ui.constants.Browser;

public abstract class BrowserUtility {

	Logger logger = LoggerUtility.getLogger(this.getClass());
	// private WebDriver driver;
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public BrowserUtility(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			driver.set(new FirefoxDriver());
		} else {
			System.out.println("Invalid Browser!! | Enter Valid Browser from list - Chrome,FrieFox");
		}
	}

	public BrowserUtility(Browser browserName) {
		logger.info("Opening " + browserName + " Browser");
		if (browserName == Browser.CHROME) {
			driver.set(new ChromeDriver());
		} else if (browserName == Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
		}
	}

	public BrowserUtility(Browser browserName, boolean isHeadless) {

		if (isHeadless) {

			logger.info("Opening " + browserName + " and Browser is set to Headless");
			if (browserName == Browser.CHROME) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=old");
				options.addArguments("--windows-size=1920,1080");
				driver.set(new ChromeDriver(options));
			} else if (browserName == Browser.FIREFOX) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=old");
				options.addArguments("--disable-gpu");
				driver.set(new FirefoxDriver());
			}

		} else {

			logger.info("Opening " + browserName + " Browser");
			if (browserName == Browser.CHROME) {
				driver.set(new ChromeDriver());
			} else if (browserName == Browser.FIREFOX) {
				driver.set(new FirefoxDriver());
			}
		}
	}

	public BrowserUtility(WebDriver driver) {

		this.driver.set(driver);
	}

	public WebDriver getDriver() {
		return driver.get();
	}

	public void clickOn(By locator) {
		logger.info("Finding the locator: " + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Element found perform Click Action");
		element.click();
	}

	public void enterText(By locator, String enterText) {
		logger.info("Finding the locator: " + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Element found Sending the text " + enterText);
		element.sendKeys(enterText);
	}

	public void goToWebsite(String url) {
		logger.info("Opening the URL: " + url);
		driver.get().get(url);
	}

	public String getVisibleText(By locator) {
		logger.info("Finding the locator: " + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("element found returning visible text: " + element.getText());
		return element.getText();
	}

	public String getScreenShot(String name) {
		TakesScreenshot ts = (TakesScreenshot) driver.get();
		File scource = ts.getScreenshotAs(OutputType.FILE);
		String fileaPath="./SreenShots/"+name+".png";
		File path = new File(fileaPath);
		try {
			FileUtils.copyFile(scource, path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path.toString();
	}

}
