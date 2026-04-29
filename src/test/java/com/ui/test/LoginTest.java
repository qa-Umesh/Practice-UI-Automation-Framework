package com.ui.test;

import org.testng.AssertJUnit;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pojo.User;

@Listeners(com.ui.listners.TestListner.class)
public class LoginTest extends BaseTest {

//	@Test(dataProviderClass = com.ui.dataProvider.LoginDataProvider.class, dataProvider = "jsonLoginDataProviderf")
//	public void loginJSONTest(User user) {
//
//		assertEquals(homePage.goToLoginPage().performLoginWith(user.getEmail(), user.getPassword()).getHomeText(),
//				"Umesh kute");
//	}
//
//	@Test(dataProviderClass = com.ui.dataProvider.LoginDataProvider.class, dataProvider = "csvLoginDataProvider")
//	public void loginCsvTest(User user) {
//
//		assertEquals(homePage.goToLoginPage().performLoginWith(user.getEmail(), user.getPassword()).getHomeText(),
//				"Umesh kute");
//	}
//	@Test(dataProviderClass = com.ui.dataProvider.LoginDataProvider.class, dataProvider = "ExcelLoginDataProvider", retryAnalyzer = com.ui.listners.MyRetryAnalyser.class)

	@Test(dataProviderClass = com.ui.dataProvider.LoginDataProvider.class, dataProvider = "ExcelLoginDataProvider")
	public void loginExcelTest(User user) {

		AssertJUnit.assertEquals(
				homePage.goToLoginPage().performLoginWith(user.getEmail(), user.getPassword()).getHomeText(),
				"Umesh kute");
	}
}
