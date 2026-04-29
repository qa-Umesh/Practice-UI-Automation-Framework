package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {

	public static Iterator<User> loginExcelReader(String fileName) {
		File loginData = new File(
				System.getProperty("user.dir") + File.separator + "testData" + File.separator + fileName);

		XSSFWorkbook workBook;
		XSSFSheet sheet;
		Row row;
		User user;
		List<User> userList = null;
		Iterator<Row> iterator;
		Cell email,password;

		try {
			workBook = new XSSFWorkbook(loginData);
			sheet = workBook.getSheet("sheet1");
			iterator = sheet.iterator();
			iterator.next();
			userList = new ArrayList<User>();
			while (iterator.hasNext()) {
				row = iterator.next();
			    email = row.getCell(0);
				password = row.getCell(1);
				user = new User(email.toString(), password.toString());
				userList.add(user);

			}

		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return userList.iterator();
	}

}
