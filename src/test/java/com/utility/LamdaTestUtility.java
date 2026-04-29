package com.utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LamdaTestUtility {

	private static final String HUB_URL = "https://hub.lambdatest.com/wd/hub";
	private static ThreadLocal<WebDriver> localDriver = new ThreadLocal<WebDriver>();
	private static ThreadLocal<DesiredCapabilities> localCapability = new ThreadLocal<DesiredCapabilities>();

	public static WebDriver createLamdaTestSession(String browser, String testName) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", browser);
		capabilities.setCapability("browserVersion", "latest");
		Map<String, Object> ltOptions = new HashMap<>();
		ltOptions.put("user", "umeshkute354");
		ltOptions.put("accessKey", "LT_PyeVXTmts6SL1lwTeZSOWGGl5Rv93pkPcHajC6SDHnfULse");
		ltOptions.put("build", "Selenium 4");
		ltOptions.put("name", testName);
		ltOptions.put("platformName", "Windows 10");
		ltOptions.put("seCdp", true);
		ltOptions.put("selenium_version", "latest");
		capabilities.setCapability("LT:Options", ltOptions);
		localCapability.set(capabilities);
		WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(new URL(HUB_URL), localCapability.get());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		localDriver.set(driver);

		return localDriver.get();
	}
	
	public static void quiteSession() {
		if(localDriver !=null) {
			localDriver.get().quit();
		}
	}

}
