package com.ui.dataProvider;

import java.util.Iterator;

import org.testng.annotations.DataProvider;

import com.ui.pojo.User;
import com.utility.CsvReaderUtility;
import com.utility.ExcelReaderUtility;
import com.utility.JSONReaderUtility;

public class LoginDataProvider {
	
	@DataProvider(name="jsonLoginDataProviderf")
	public Iterator<Object[]> JsonLoginData() {
		return JSONReaderUtility.readLoginData("loginData");
	}
	
	@DataProvider(name = "csvLoginDataProvider")
	public Iterator<User> CsvLoginData() {
		return CsvReaderUtility.getloginData("loginData.csv");
	}
	
	@DataProvider(name="ExcelLoginDataProvider")
	public Iterator<User> ExcelLoginData() {
		return ExcelReaderUtility.loginExcelReader("loginData.xlsx");
	}

}
